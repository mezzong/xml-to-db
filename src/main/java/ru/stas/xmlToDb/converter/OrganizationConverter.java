package ru.stas.xmlToDb.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.stas.xmlToDb.controller.FileController;
import ru.stas.xmlToDb.model.Organization;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrganizationConverter implements Converter {
    private static final Logger LOG = LoggerFactory.getLogger(FileController.class.getName());

    @Override
    public Organization convertElement(Element org) {
        Organization organization = new Organization();
        try {
            organization.setId(Integer
                    .parseInt(org.getElementsByTagName("id").item(0).getTextContent()));
            organization.setName(org.getElementsByTagName("name").item(0).getTextContent());
        } catch (Exception e) {
            LOG.error("Exception in FileController", e);
        }
        return organization;
    }

    @Override
    public Map<Integer, Organization> convertNodeList(NodeList nodeList) {
        Map<Integer, Organization> organizations = new HashMap<>();
        if (nodeList != null && nodeList.getLength() != 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Organization organization = convertElement(element);
                    organizations.put(organization.getId(), organization);
                }
            }
        }
        return organizations;
    }
}
