package com.cloudrun.microservicetemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class CloudSqlConnectionPoolFactory {

  public static DataSource createConnectionPool() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(String.format("jdbc:mysql:///helloworld"));
    config.setUsername("root");
    config.setPassword("V!s4f@cA0(6)");
    config.addDataSourceProperty("socketFactory","com.google.cloud.sql.mysql.SocketFactory");
    config.addDataSourceProperty("cloudSqlInstance", "neon-lock-454313-h0:us-south1:th34msrv");

    return new HikariDataSource(config);
  }

}