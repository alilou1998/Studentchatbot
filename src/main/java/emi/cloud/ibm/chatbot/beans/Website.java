package emi.cloud.ibm.chatbot.beans;

public class Website {

    private String ecole;
    private String link;

    public Website(String ecole, String link) {
        this.ecole = ecole;
        this.link = link;
    }

    public Website() {
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
