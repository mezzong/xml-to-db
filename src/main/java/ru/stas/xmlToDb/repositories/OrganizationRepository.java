package ru.stas.xmlToDb.repositories;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stas.xmlToDb.db.DataBaseUtility;
import ru.stas.xmlToDb.model.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@org.springframework.stereotype.Repository
public class OrganizationRepository implements Repository {

    private static final Logger LOG =
            LoggerFactory.getLogger(OrganizationRepository.class.getName());

    @Override
    public Map<Integer, Organization> insertOrganizations(
            Map<Integer, Organization> organizationMap) {
        Map<Integer, Organization> orgsToInsert = new HashMap<>(organizationMap);
        try (BasicDataSource dataSource = DataBaseUtility.getDataSource();
             Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection
                     .prepareStatement("INSERT INTO organization VALUES (?, ?)")) {
            Set<Integer> existIds = getExistId(orgsToInsert.keySet(), connection);
            //Delete duplicated
            orgsToInsert.keySet().removeAll(existIds);
            for (Integer key : orgsToInsert.keySet()) {
                Organization org = orgsToInsert.get(key);
                pstmt.setInt(1, org.getId());
                pstmt.setString(2, org.getName());
                pstmt.addBatch();
                pstmt.clearParameters();
            }
            pstmt.executeBatch();
        } catch (Exception e) {
            LOG.error("Exception in OrganizationRepository insertOrganizationsById()", e);
        }
        return orgsToInsert;
    }

    private Set<Integer> getExistId(Set<Integer> ids, Connection connection) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : ids) {
            if (!sb.toString().isEmpty()) {
                sb.append(", ");
            }
            sb.append(i);
        }
        Set<Integer> result = new HashSet<>();
        try (Statement statement = connection
                .createStatement()) {
            String sql =
                    String.format("SELECT id FROM organization WHERE id IN (%s)", sb.toString());
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(Integer.parseInt(resultSet.getString(1)));
            }
        } catch (Exception e) {
            LOG.error("Exception in OrganizationRepository getAllId()", e);
        }
        return result;
    }
}
