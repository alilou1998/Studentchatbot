package emi.cloud.ibm.chatbot.beans;

public class AdmissionDetails {

    private String spec;
    private String admission;
    private String schools;

    public AdmissionDetails() {
    }


    public AdmissionDetails(String spec, String admission, String schools) {
        this.spec = spec;
        this.admission = admission;
        this.schools = schools;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getSchools() {
        return schools;
    }

    public void setSchools(String schools) {
        this.schools = schools;
    }
}
