package io.dataease.plugins.datasource.intersystems.provider;

import com.intersys.jdbc.CacheDriver;
import io.dataease.plugins.datasource.entity.JdbcConfiguration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntersystemsConfig extends JdbcConfiguration {

    private String driver = "com.intersys.jdbc.CacheDriver";
    private String extraParams;


    public String getJdbc() {
        return "jdbc:Cache://HOST:PORT/DATABASE"
                .replace("HOST", getHost().trim())
                .replace("PORT", getPort().toString())
                .replace("DATABASE", getDataBase().trim());
    }
}
