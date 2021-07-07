package ru.stas.xmlToDb.repositories;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.stas.xmlToDb.db.DataBaseUtility;
import ru.stas.xmlToDb.model.Organization;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class OrganizationRepository implements Repository {

    BasicDataSource dataSource = DataBaseUtility.getDataSource();

    @Override
    public int insertBatchOrganizations(Map<Integer, Organization> collection) {
        int addedEntries = 0;
        Set<Integer> allId = getAllId();
        Set<Integer> uniqId = new HashSet<>(collection.keySet());
        uniqId.removeAll(allId);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection
                     .prepareStatement("INSERT INTO organization VALUES (?, ?)")) {
            for (Integer key : uniqId) {
                Organization org = collection.get(key);
                pstmt.setInt(1, org.getId());
                pstmt.setString(2, org.getName());
                pstmt.addBatch();
                pstmt.clearParameters();
                int[] rslBatch = pstmt.executeBatch();
                System.out.println(rslBatch.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addedEntries;
    }

    public Set<Integer> getAllId() {
        Set<Integer> result = new HashSet<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection
                     .createStatement()) {
            String sql = "SELECT id FROM organization";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(Integer.parseInt(resultSet.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Organization add(Organization item) {
        return null;
    }

    @Override
    public boolean replace(String id, Organization item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Organization> findAll() {
        List<Organization> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection
                     .createStatement()) {
            String sql = "SELECT * FROM organization";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String name = resultSet.getString(2);
                result.add(new Organization(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Organization> findByName(String key) {
        return null;
    }

    @Override
    public Organization findById(String id) {

        return null;
    }

}
