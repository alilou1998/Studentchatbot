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
                        "aux écoles suivante:" +
                        "\n\t Facultés des sciences économiques, juridiques et sociales" +
                        "\n\t Facultés des lettres et des sciences humaines" +
                        "\n\t Facultés polydisciplinaires" +
                        "\n\t Facultés de l’Université Quaraouiyine Fès");
        List<SpecialitesDetails> specialitesDetails = new ArrayList<>(Arrays.asList(details1, details2, details3, details4));

        return specialitesDetails;

    }

}
