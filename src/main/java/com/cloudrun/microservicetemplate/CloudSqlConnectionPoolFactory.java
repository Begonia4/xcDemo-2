package com.cloudrun.microservicetemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class CloudSqlConnectionPoolFactory {

  public static DataSource createConnectionPool() {
    String DB_NAME = "helloworld";
    String DB_USER = "root";
    String DB_PASS = "V!s4f@cA0(6";
    String INSTANCE_CONNECTION_NAME = "neon-lock-454313-h0:us-central1:th34msr";
     
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(String.format("jdbc:mysql:///" + DB_NAME));
    config.setUsername(DB_USER);
    config.setPassword(DB_PASS);
    config.addDataSourceProperty("socketFactory","com.google.cloud.sql.mysql.SocketFactory");
    config.addDataSourceProperty("cloudSqlInstance", INSTANCE_CONNECTION_NAME);

    return new HikariDataSource(config);
  }

}