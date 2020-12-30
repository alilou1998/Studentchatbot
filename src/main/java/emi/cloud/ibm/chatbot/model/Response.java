package emi.cloud.ibm.chatbot.model;

public class Response {

    String link;
    String ecoleDescription;

    public Response(String link,String ecoleDescription) {
        this.ecoleDescription= ecoleDescription;
        this.link = link;
    }

    public Response() {
    }

    public String getEcoleDescription() {
        return ecoleDescription;
    }

    public void setEcoleDescription(String ecoleDescription) {
        this.ecoleDescription = ecoleDescription;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
