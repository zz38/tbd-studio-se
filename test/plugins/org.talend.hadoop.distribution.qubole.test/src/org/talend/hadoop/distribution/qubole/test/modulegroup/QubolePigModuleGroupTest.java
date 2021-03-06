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
package org.talend.hadoop.distribution.qubole.test.modulegroup;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.qubole.QuboleConstant;
import org.talend.hadoop.distribution.qubole.modulegroup.QubolePigModuleGroup;

public class QubolePigModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<>();
        results.put(QuboleConstant.BIGDATALAUNCHER_MODULE_GROUP.getModuleName(), null);
        results.put(QuboleConstant.S3_MODULE_GROUP.getModuleName(), null);
        results.put(QuboleConstant.PIG_PARQUET_MODULE_GROUP.getModuleName(), "(LOAD=='PARQUETLOADER') OR (STORE=='PARQUETSTORER')");
        results.put(QuboleConstant.PIG_AVRO_MODULE_GROUP.getModuleName(), "(LOAD=='AVROSTORAGE') OR (STORE=='AVROSTORAGE')");
        results.put(QuboleConstant.PIG_SEQUENCEFILE_MODULE_GROUP.getModuleName(), "(LOAD=='SEQUENCEFILELOADER') OR (STORE=='SEQUENCEFILESTORAGE')");
        results.put(QuboleConstant.PIG_RCFILE_MODULE_GROUP.getModuleName(), "(LOAD=='RCFILEPIGSTORAGE') OR (STORE=='RCFILEPIGSTORAGE')");
        
        Set<DistributionModuleGroup> moduleGroups = QubolePigModuleGroup.getModuleGroups();
        assertEquals(6, moduleGroups.size());

        for (DistributionModuleGroup group : moduleGroups) {
            assertEquals(results.get(group.getModuleName()), group.getRequiredIf() == null ? null : group.getRequiredIf().getConditionString());
        }
    }
}
