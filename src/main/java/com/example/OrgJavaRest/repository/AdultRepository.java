package com.example.OrgJavaRest.repository;


import com.example.OrgJavaRest.model.AdultTrainJava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdultRepository extends JpaRepository<AdultTrainJava, Long> {

}