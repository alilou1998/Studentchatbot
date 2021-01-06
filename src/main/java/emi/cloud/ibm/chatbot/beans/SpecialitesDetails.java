package emi.cloud.ibm.chatbot.beans;

public class SpecialitesDetails {

    private String spec;
    private String response;

    public SpecialitesDetails() {
    }

    public SpecialitesDetails(String spec, String response) {
        this.spec = spec;
        this.response = response;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
