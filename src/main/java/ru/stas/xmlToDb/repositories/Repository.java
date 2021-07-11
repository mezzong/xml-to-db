package ru.stas.xmlToDb.repositories;

import ru.stas.xmlToDb.model.Organization;

import java.util.Map;


public interface Repository {
    Map<Integer, Organization> insertOrganizations(Map<Integer, Organization> organizationMap);
}
