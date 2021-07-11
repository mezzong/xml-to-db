package ru.stas.xmlToDb.parsers;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public interface Parser {

    Element getRootElement(InputStream inputStream) throws IOException, SAXException;

}
