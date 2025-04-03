package com.cloudrun.microservicetemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class CloudSqlConnectionPoolFactory {

  public static DataSource createConnectionPool() {
    String DB_NAME = "hello";
    String DB_USER = "hello";
    String DB_PASS = "hello";
    String INSTANCE_CONNECTION_NAME = "hello";
     
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(String.format("jdbc:mysql:///" + DB_NAME));
    config.setUsername(DB_USER);
    config.setPassword(DB_PASS);
    config.addDataSourceProperty("socketFactory","com.google.cloud.sql.mysql.SocketFactory");
    config.addDataSourceProperty("cloudSqlInstance", INSTANCE_CONNECTION_NAME);

    return new HikariDataSource(config);
  }

}