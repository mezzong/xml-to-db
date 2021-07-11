package ru.stas.xmlToDb.parsers;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class XmlParser implements Parser {

    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;


    public XmlParser() throws ParserConfigurationException {
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.documentBuilderFactory.setNamespaceAware(true);
        this.documentBuilderFactory.setCoalescing(true);
        this.documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    }

    public Element getRootElement(InputStream inputStreamXmlFile) throws IOException, SAXException {
        Document document = documentBuilder.parse(inputStreamXmlFile);
        return document.getDocumentElement();
    }
}
