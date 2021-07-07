package ru.stas.xmlToDb.repositories;

import ru.stas.xmlToDb.model.Organization;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Repository {

    Organization add(Organization item);

    boolean replace(String id, Organization item);

    boolean delete(String id);

    List<Organization> findAll();

    List<Organization> findByName(String key);

    Organization findById(String id);

    int insertBatchOrganizations(Map<Integer, Organization> collection);

    Set<Integer> getAllId();
}
