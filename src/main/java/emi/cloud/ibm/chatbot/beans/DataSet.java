package emi.cloud.ibm.chatbot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataSet {


    @Bean
    public List<SpecialitesDetails> getResponse(){

        SpecialitesDetails details1 =
                new SpecialitesDetails("SM","La spécialité Sciences Mathématiques peut être suivie par trois parcours:"+
                        "\n Admission sur concours \n Admission post prépas \n Admission directe");
        SpecialitesDetails details2 =
                new SpecialitesDetails("ScienceExe","La spécialité Sciences Mathématiques peut être suivi par trois parcours:\n"+
                        "\n Admission sur concours \n Admission post prépas \n Admission directe");
        SpecialitesDetails details3 =
                new SpecialitesDetails("Economie","La spécialité Sciences economiques peut être suivie par deux parcours:" +
                        "\n Admission sur concours \n Admission post prépas ou CNAEM");
        SpecialitesDetails details4 =
                new SpecialitesDetails("Lettres","La spécialité Sciences Littéraires ne possèdent qu'une admission directe" +
                        "aux écoles suivante avec admission directe:" +
                        "\n\t Facultés des sciences économiques, juridiques et sociales" +
                        "\n\t Facultés des lettres et des sciences humaines" +
                        "\n\t Facultés polydisciplinaires" +
                        "\n\t Facultés de l’Université Quaraouiyine Fès");
        List<SpecialitesDetails> specialitesDetails = new ArrayList<>(Arrays.asList(details1, details2, details3, details4));

        return specialitesDetails;

    }

    @Bean
    public List<AdmissionDetails> getAdmissionDetails(){
        AdmissionDetails details1 =
                new AdmissionDetails("SM","Admission sur concours","Liste des écoles " +
                        "accessibles: \n ENSA \n ENAM \n ENCG \n ENA ");
        AdmissionDetails details2 =
                new AdmissionDetails("SM","Admission directe","Liste des écoles " +
                        "accessibles: \n EST \n BTS \n IAV");
        AdmissionDetails details3 =
                new AdmissionDetails("SM","Admission post prépas","Vous pourrez ensuite " +
                        "accéder aux écoles suivantes: \n EMI \n ENSIAS \n ESI \n EHTP \n INPT");

        AdmissionDetails details4 =
                new AdmissionDetails("Economie","Admission sur concours","Liste des ecoles" +
                        "accesibles: \n EST \n ENCG \n FSE \n ENS \n ENSET \n ENA \n ESITH");
        AdmissionDetails details5 =
                new AdmissionDetails("Economie","Admission post prépas ou CNAEM","Vous pourrez " +
                        "accéder aux écoles suivantes:" +
                        "\n ENCG \n ISCAE");
        AdmissionDetails details6 =
                new AdmissionDetails("Lettres","Admission directe","");

        return new ArrayList<>(Arrays.asList(details1,details2,details3,details4,details5,details6));
    }

}
