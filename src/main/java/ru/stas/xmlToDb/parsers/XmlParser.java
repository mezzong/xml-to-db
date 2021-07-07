package ru.stas.xmlToDb.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParser implements Parser {

    private final File xmlFile;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;

    public XmlParser(File file) throws ParserConfigurationException {
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.documentBuilderFactory.setNamespaceAware(true);
        this.documentBuilderFactory.setCoalescing(true);
        this.documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        this.xmlFile = file;
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    }

    public Element getRootElement() throws IOException, SAXException {
        Document document = documentBuilder.parse(xmlFile);
        return document.getDocumentElement();
    }
}
