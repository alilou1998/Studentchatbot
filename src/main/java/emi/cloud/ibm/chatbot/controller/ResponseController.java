package emi.cloud.ibm.chatbot.controller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import emi.cloud.ibm.chatbot.beans.AdmissionDetails;
import emi.cloud.ibm.chatbot.beans.SpecialitesDetails;
import emi.cloud.ibm.chatbot.dao.ReponseDao;
import emi.cloud.ibm.chatbot.model.Reponse;
import emi.cloud.ibm.chatbot.model.Request;
import emi.cloud.ibm.chatbot.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class ResponseController {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ReponseDao reponseDao;

    @Autowired
    List<SpecialitesDetails> specialitesDetailsList;

    @Autowired
    List<AdmissionDetails> admissionDetailsList;

    @Autowired
    public ResponseController(ReponseDao reponseDao) {
        this.reponseDao = reponseDao;
    }

    @GetMapping("/reponses")
    public List<Reponse> getReponses() {
        return reponseDao.findAll();
    }

    @GetMapping("/reponses/{spec}")
    public Reponse getReponse(@PathVariable String spec) {
        return reponseDao.findBySpec(spec);
    }

    @PostMapping("/reponses")
    public Response postSpeciality(@RequestBody Request request) {
        if (request.getEcole() != null) {
            String URL = "https://duckduckgo.com/?q=" + request.getEcole() + "+9rayti";
            logger.info(decodeValue(scrappingMethod(URL, request)));
            return new Response("", decodeValue(scrappingMethod(URL, request)), "");
        } else if (request.getSpec() != null && request.getTypeAdmission()==null) {
            List<SpecialitesDetails> details = specialitesDetailsList.stream().filter(e ->
                    e.getSpec().equals(request.getSpec())
            ).collect(Collectors.toList());
            return new Response("", "", details.get(0).getResponse());
//            Random r = new Random();
//            Reponse reponse = reponseDao.findBySpec(request.getSpec());
//            int max = reponse.getLinks().size();
//            int random = r.ints(0, (max)).limit(1).findFirst().getAsInt();
//            logger.info("Index " + random);
//            return new Response(reponseDao.findBySpec(request.getSpec()).getLinks().get(random), "");
        }else if(request.getSpec() != null && request.getTypeAdmission()!=null){
            List<AdmissionDetails> details = admissionDetailsList.stream().filter(c->
                            c.getAdmission().equals(request.getTypeAdmission()) && c.getSpec().equals(request.getSpec())
                    ).collect(Collectors.toList());
            return new Response("", "", details.get(0).getSchools());
        }else {
            return null;
        }
    }



    public static String decodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    static String scrappingMethod(String Url, Request request) {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
        try {
            HtmlPage page = client.getPage(Url);
            System.out.println(page.toString());
            System.out.println("Done");
            //DomElement main = page.getElementById("main");
            //List<HtmlElement> items = (List<HtmlElement>) mainTable.getByXPath("//table");
            List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//a[@class='result__a']");
            if (items.isEmpty()) {
                System.out.println("No items found");
            } else {
                for (HtmlElement item : items) {
                    String attribute = item.getAttribute("href");
                    if (attribute.contains("www.9rayti.com") && attribute.contains(request.getEcole().toLowerCase())) {
                        String s = attribute.substring(39);
                        return new String(s.getBytes(StandardCharsets.UTF_8), StandardCharsets.US_ASCII);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
