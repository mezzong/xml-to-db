package ru.stas.xmlToDb;

import org.xml.sax.SAXException;
import ru.stas.xmlToDb.converter.OrganizationConverter;
import ru.stas.xmlToDb.model.Organization;
import ru.stas.xmlToDb.parsers.XmlParser;
import ru.stas.xmlToDb.repositories.OrganizationRepository;
import ru.stas.xmlToDb.repositories.Repository;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("test.xml");
        XmlParser xmlParser = new XmlParser(xmlFile);
        OrganizationConverter converter = new OrganizationConverter();
        Map<Integer, Organization> organizations =
                converter.convert(xmlParser.getRootElement().getElementsByTagName("organization"));
        Repository repository = new OrganizationRepository();
        repository.insertBatchOrganizations(organizations);
        List<Organization> allEl = repository.findAll();
        System.out.println(allEl.size());
    }
}
