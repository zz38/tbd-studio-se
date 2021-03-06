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
package org.talend.hadoop.distribution.dataproc11.modulegroup.node.sparkstreaming;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.common.SparkStreamingLinkedNodeCondition;
import org.talend.hadoop.distribution.constants.SparkStreamingConstant;

public class Dataproc11SparkStreamingKafkaAvroModuleGroup {

    public static final String KAFKA_AVRO_GROUP_NAME = "SPARK-KAFKA-AVRO-LIB-MRREQUIRED-DATAPROC11"; //$NON-NLS-1$

    public static Set<DistributionModuleGroup> getModuleGroups(String distribution, String version) {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        DistributionModuleGroup dmg = new DistributionModuleGroup(KAFKA_AVRO_GROUP_NAME, true,
                new SparkStreamingLinkedNodeCondition(distribution, version,
                        SparkStreamingConstant.KAFKA_SPARKCONFIGURATION_LINKEDPARAMETER).getCondition());
        hs.add(dmg);
        // Add Spark Streaming Kafka dependencies as well
        hs.addAll(Dataproc11SparkStreamingKafkaAssemblyModuleGroup.getModuleGroups(distribution, version));
        return hs;
    }
}
