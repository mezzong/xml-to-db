package ru.stas.xmlToDb.converter;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.stas.xmlToDb.model.Organization;

import java.util.Map;

public interface Converter {

    Organization convertElement(Element org);

    Map<Integer, Organization> convertNodeList(NodeList nodeList);
}
