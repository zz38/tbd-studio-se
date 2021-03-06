// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.dataproc11.test.modulegroup;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.dataproc11.Dataproc11Constant;
import org.talend.hadoop.distribution.dataproc11.modulegroup.Dataproc11SparkStreamingModuleGroup;

public class Dataproc11SparkStreamingModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<>();
        results.put(Dataproc11Constant.HDFS_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.MAPREDUCE_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.SPARK_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.BIGDATALAUNCHER_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')");
        results.put(Dataproc11Constant.SPARK_MRREQUIRED_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.SPARK_KAFKA_CLIENT_MRREQUIRED_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.SPARK_KAFKA_AVRO_MRREQUIRED_MODULE_GROUP.getModuleName(), "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$
        results.put(Dataproc11Constant.SPARK_KAFKA_ASSEMBLY_MRREQUIRED_MODULE_GROUP.getModuleName(),
                "(SPARK_LOCAL_MODE=='false')"); //$NON-NLS-1$

        Set<DistributionModuleGroup> moduleGroups = Dataproc11SparkStreamingModuleGroup.getModuleGroups();
        assertEquals(8, moduleGroups.size());

        for (DistributionModuleGroup module : moduleGroups) {
            assertTrue("Should contain module " + module.getModuleName(), results.containsKey(module.getModuleName())); //$NON-NLS-1$
            if (results.get(module.getModuleName()) == null) {
                assertTrue("The condition of the module " + module.getModuleName() + " is not null.", //$NON-NLS-1$ //$NON-NLS-2$
                        results.get(module.getModuleName()) == null);
            } else {
                assertTrue("The condition of the module " + module.getModuleName() + " is null, but it should be " //$NON-NLS-1$ //$NON-NLS-2$
                        + results.get(module.getModuleName()) + ".", results.get(module.getModuleName()) != null); //$NON-NLS-1$
                assertEquals(results.get(module.getModuleName()), module.getRequiredIf().getConditionString());
            }
        }
    }
}
