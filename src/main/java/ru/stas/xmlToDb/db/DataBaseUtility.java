package ru.stas.xmlToDb.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.InputStream;
import java.util.Properties;


public class DataBaseUtility {
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource() {

        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            Properties prs = new Properties();
            ClassLoader classLoader = DataBaseUtility.class.getClassLoader();
            try (InputStream in = classLoader.getResourceAsStream("app.properties")) {
                prs.load(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ds.setUrl(prs.getProperty("url"));
            ds.setUsername(prs.getProperty("login"));
            ds.setPassword(prs.getProperty("password"));

            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }
}