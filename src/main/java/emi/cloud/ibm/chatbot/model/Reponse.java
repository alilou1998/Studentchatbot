package emi.cloud.ibm.chatbot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String spec;
    @ElementCollection
    private List<String> links = new ArrayList<>();

    public Reponse(String spec) {
        this.spec = spec;
    }

    public Reponse() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> link) {
        this.links = link;
    }
}
