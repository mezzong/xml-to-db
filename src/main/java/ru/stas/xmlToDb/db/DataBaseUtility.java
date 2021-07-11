package ru.stas.xmlToDb.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stas.xmlToDb.controller.FileController;

import java.io.InputStream;
import java.util.Properties;


public class DataBaseUtility {
    private static BasicDataSource dataSource;
    private static final Logger LOG = LoggerFactory.getLogger(FileController.class.getName());


    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            Properties prs = new Properties();
            ClassLoader classLoader = DataBaseUtility.class.getClassLoader();
            try (InputStream in = classLoader.getResourceAsStream("application.properties")) {
                prs.load(in);
            } catch (Exception e) {
                LOG.error("Exception in BasicDataSource", e);
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