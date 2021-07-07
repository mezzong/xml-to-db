package ru.stas.xmlToDb.converter;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.stas.xmlToDb.model.Organization;

import java.util.HashMap;
import java.util.Map;


public class OrganizationConverter {

    public Organization convert(Element org) {
        Organization organization = new Organization();
        try {
            organization.setId(Integer.parseInt(org.getElementsByTagName("id").item(0).getTextContent()));
            organization.setName(org.getElementsByTagName("id").item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organization;
    }

    public Map<Integer, Organization> convert(NodeList nodeList) {
        Map<Integer, Organization> organizations = new HashMap<>();
        if (nodeList != null && nodeList.getLength() != 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Organization organization = convert(element);
                    organizations.put(organization.getId(), organization);
                }
            }
        }
        return organizations;
    }
}
