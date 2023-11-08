package io.dataease.plugins.datasource.intersystems.service;

import io.dataease.plugins.common.constants.DatabaseClassification;
import io.dataease.plugins.common.constants.DatasourceCalculationMode;
import io.dataease.plugins.common.dto.StaticResource;
import io.dataease.plugins.common.dto.datasource.DataSourceType;
import io.dataease.plugins.datasource.service.DatasourceService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class IntersystemsService extends DatasourceService {


    @Override
    public List<String> components() {
        List<String> result = new ArrayList<>();
        result.add("intersystems");
        return result;
    }
    @Override
    protected InputStream readContent(String s) {
        return this.getClass().getClassLoader().getResourceAsStream("static/" + s);
    }


    @Override
    public List<StaticResource> staticResources() {
        List<StaticResource> results = new ArrayList<>();
        StaticResource staticResource = new StaticResource();
        staticResource.setName("intersystems");
        staticResource.setSuffix("jpg");
        results.add(staticResource);
        results.add(pluginSvg());
        return results;
    }

    @Override
    public DataSourceType getDataSourceType() {
        DataSourceType dataSourceType = new DataSourceType("intersystems", "intersystems" , true , "", DatasourceCalculationMode.DIRECT, true);
        dataSourceType.setKeywordPrefix("\"");
        dataSourceType.setKeywordSuffix("\"");
        dataSourceType.setAliasPrefix("\"");
        dataSourceType.setAliasSuffix("\"");
        dataSourceType.setDatabaseClassification(DatabaseClassification.OLTP);
        return dataSourceType;
    }

    private StaticResource pluginSvg() {
        StaticResource staticResource = new StaticResource();
        staticResource.setName("intersystems-backend");
        staticResource.setSuffix("svg");
        return staticResource;
    }
}
