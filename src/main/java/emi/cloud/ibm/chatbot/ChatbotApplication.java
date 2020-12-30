package emi.cloud.ibm.chatbot;

import emi.cloud.ibm.chatbot.dao.ReponseDao;
import emi.cloud.ibm.chatbot.model.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ChatbotApplication implements CommandLineRunner {

    private final ReponseDao reponseDao;

    @Autowired
    public ChatbotApplication(ReponseDao reponseDao) {
        this.reponseDao = reponseDao;
    }


    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Reponse reponse = new Reponse("SM");
        reponse.getLinks().add("https://www.concourat.com/orientation-apres-bac-maroc/les-ecoles-apres-un-bac-sciences-maths-au-maroc/");
        reponse.getLinks().add("https://www.concourat.com/orientation-apres-bac-maroc/les-ecoles-apres-un-bac-sciences-maths-au-maroc/");
        reponse.getLinks().add("https://www.concourat.com/orientation-apres-bac-maroc/les-ecoles-apres-un-bac-sciences-maths-au-maroc/");
        Reponse reponse1 = new Reponse("S Exe PC");
        reponse1.getLinks().add("www.pc1.com");
        reponse1.getLinks().add("www.pc2.com");
        reponse1.getLinks().add("www.pc3.com");
        reponseDao.save(reponse);
        reponseDao.save(reponse1);
    }
}
