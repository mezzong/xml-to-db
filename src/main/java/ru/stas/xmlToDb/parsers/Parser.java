package ru.stas.xmlToDb.parsers;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;

public interface Parser {

    public Element getRootElement() throws IOException, SAXException;

}
