package emi.cloud.ibm.chatbot.dao;

import emi.cloud.ibm.chatbot.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseDao extends JpaRepository<Reponse, String> {

    @Query("select spec from Reponse spec where spec.spec=:spec")
    Reponse findBySpec(String spec);

}
