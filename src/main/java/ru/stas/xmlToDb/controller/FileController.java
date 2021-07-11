package ru.stas.xmlToDb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import ru.stas.xmlToDb.converter.Converter;
import ru.stas.xmlToDb.model.Organization;
import ru.stas.xmlToDb.parsers.Parser;
import ru.stas.xmlToDb.repositories.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class.getName());

    @Autowired
    private Repository repository;

    @Autowired
    private Parser parser;

    @Autowired
    private Converter converter;

    @RequestMapping(value = "upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, Model model) {
        if (multipartFile.isEmpty()) {
            return "File is empty";
        }
        try (InputStream in = multipartFile.getInputStream()) {
            Map<Integer, Organization> organizationMap = converter.convertNodeList(
                    parser.getRootElement(in).getChildNodes());
            Map<Integer, Organization> insertedMap =
                    repository.insertOrganizations(organizationMap);
            model.addAttribute("organizations", new ArrayList<>(insertedMap.values()));
            model.addAttribute("numRow", insertedMap.size());
            model.addAttribute("msg", "Processing completed");
        } catch (SAXException e) {
            LOG.error("SAXException in FileController", e);
            model.addAttribute("msg", "Invalid xml file");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            model.addAttribute("msg", e.getMessage());
        }
        return "result";
    }
}
