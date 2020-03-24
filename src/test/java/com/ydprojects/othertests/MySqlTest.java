package com.ydprojects.othertests;

import com.ydprojects.util.HibernateUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlTest {

    private static String USERNAME;
    private static  String PASSWORD;
    private static  String CONNURL;
    private static  Logger LOG = LoggerFactory.getLogger(MySqlTest.class);

    private void loadProperties() {
        HibernateUtil.loadProperties();
        USERNAME = HibernateUtil.USERNAME;
        PASSWORD = HibernateUtil.PASSWORD;
        CONNURL = HibernateUtil.CONN_URL;
    }

    @Test
    public void testConnection ()  {
        loadProperties();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNURL,USERNAME,PASSWORD);
           LOG.info("Successfully connected");
        } catch (SQLException e) {
            LOG.info("{}",e);
        }
        finally {
            if(connection != null) {
                try {
                    connection.close();
                    LOG.info("Connection closed");
                } catch (SQLException e) {
                  LOG.info("{}",e);
                }
            }
        }

    }
}