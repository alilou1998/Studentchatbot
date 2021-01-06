package emi.cloud.ibm.chatbot.model;

public class Response {

    String link;
    String ecoleDescription;
    String specialiteDetails;

    public Response(String link,String ecoleDescription,String specialiteDetails) {
        this.ecoleDescription= ecoleDescription;
        this.link = link;
        this.specialiteDetails=specialiteDetails;
    }

    public Response() {
    }

    public String getSpecialiteDetails() {
        return specialiteDetails;
    }

    public void setSpecialiteDetails(String specialiteDetails) {
        this.specialiteDetails = specialiteDetails;
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
