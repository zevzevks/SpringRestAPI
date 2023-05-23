package com.example.OrgJavaRest.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.OrgJavaRest.model.AdultTrainJava;
import com.example.OrgJavaRest.repository.AdultRepository;
import com.example.OrgJavaRest.request.CriteriaFilter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("adults")
public class AdultController {

    private static final Logger logger = LogManager.getLogger(AdultController.class);
    @Autowired
    AdultRepository repository;
    @PersistenceContext
    private EntityManager entityManager;


    @GetMapping("list/{id}")
    public AdultTrainJava getAdult(@PathVariable Long id) {
        logger.debug("In Rest API /adults/list/id");
        Optional<AdultTrainJava> tempAdult = repository.findById(id);
        return tempAdult.get();
    }

    @PostMapping("/queryAdultTrain")
    public String queryAdultTrain(@RequestBody String jsonReq) throws Exception {
        logger.debug("In Rest API /adults/queryAdultTrain");
        String selectQuery = "SELECT AT.* FROM ADULT_TRAIN_JAVA AT WHERE 1=1";
        System.out.println(jsonReq);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<CriteriaFilter> criteriaList = mapper.readValue(jsonReq, new TypeReference<List<CriteriaFilter>>() {});
            for (int i = 0; i < criteriaList.size(); i++) {
                if (criteriaList.get(i).getColumnValueStr() == null)
                    selectQuery += " AND " + criteriaList.get(i).getColumnName() + "=" + criteriaList.get(i).getColumnValueInt();
                else if (criteriaList.get(i).getColumnValueStr() != null)
                    selectQuery += " AND " + criteriaList.get(i).getColumnName() + "=" + "\"" + criteriaList.get(i).getColumnValueStr() + "\"";
                else
                    throw new Exception("BAD REQUEST TYPE");
            }
        } catch (Exception e){
            throw new Exception("couldnt parse Request String"+e);
        }

        List<AdultTrainJava> results = entityManager.createNativeQuery(selectQuery).getResultList();

        ObjectMapper map2 = new ObjectMapper();
        //map2.convertValue(results.get(0), new TypeReference<List<queryResultDto>>() {});

        logger.debug("Response Data:"+results);
        System.out.println("Response Array:"+results);
        return map2.writeValueAsString(results);
    }


}