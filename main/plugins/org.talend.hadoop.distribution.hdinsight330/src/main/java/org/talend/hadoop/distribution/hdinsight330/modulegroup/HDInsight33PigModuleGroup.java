// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.hdinsight330.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.BasicExpression;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.SimpleComponentCondition;
import org.talend.hadoop.distribution.constants.PigConstant;
import org.talend.hadoop.distribution.hdinsight330.HDInsight33Constant;

public class HDInsight33PigModuleGroup {

    public static Set<DistributionModuleGroup> getModuleGroups() {

        ComponentCondition parquetLoaderCondition = new SimpleComponentCondition(new BasicExpression(
                PigConstant.LOADER_PARAMETER, EqualityOperator.EQ, PigConstant.PARQUET_LOADER_VALUE));
        ComponentCondition hcatLoaderCondition = new SimpleComponentCondition(new BasicExpression(PigConstant.LOADER_PARAMETER,
                EqualityOperator.EQ, PigConstant.HCAT_LOADER_VALUE));
        ComponentCondition avroLoaderCondition = new SimpleComponentCondition(new BasicExpression(PigConstant.LOADER_PARAMETER,
                EqualityOperator.EQ, PigConstant.AVRO_LOADER_VALUE));
        ComponentCondition rcfileLoaderCondition = new SimpleComponentCondition(new BasicExpression(PigConstant.LOADER_PARAMETER,
                EqualityOperator.EQ, PigConstant.RCFILE_LOADER_VALUE));
        ComponentCondition sequencefileLoaderCondition = new SimpleComponentCondition(new BasicExpression(
                PigConstant.LOADER_PARAMETER, EqualityOperator.EQ, PigConstant.SEQUENCEFILE_LOADER_VALUE));

        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(HDInsight33Constant.PIG_HCATALOG_MODULE_GROUP.getModuleName(), false,
                hcatLoaderCondition));
        hs.add(new DistributionModuleGroup(HDInsight33Constant.PIG_PARQUET_MODULE_GROUP.getModuleName(), false,
                parquetLoaderCondition));
        hs.add(new DistributionModuleGroup(HDInsight33Constant.PIG_AVRO_MODULE_GROUP.getModuleName(), false, avroLoaderCondition));
        hs.add(new DistributionModuleGroup(HDInsight33Constant.PIG_RCFILE_MODULE_GROUP.getModuleName(), false,
                rcfileLoaderCondition));
        hs.add(new DistributionModuleGroup(HDInsight33Constant.PIG_SEQUENCEFILE_MODULE_GROUP.getModuleName(), false,
                sequencefileLoaderCondition));

        hs.add(new DistributionModuleGroup(HDInsight33Constant.BIGDATALAUNCHER_MODULE_GROUP.getModuleName()));
        hs.add(new DistributionModuleGroup(HDInsight33Constant.HDINSIGHTCOMMON_MODULE_GROUP.getModuleName()));
        return hs;
    }
}