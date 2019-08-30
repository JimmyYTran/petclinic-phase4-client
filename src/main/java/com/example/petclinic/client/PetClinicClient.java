package com.example.petclinic.client;

import com.example.petclinic.client.workflow.ClientWorkflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PetClinicClient {

    private static final Logger log = LoggerFactory.getLogger(PetClinicClient.class);

    public static void main(String args[]) {
        SpringApplication.run(PetClinicClient.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(ClientWorkflow workflow) throws Exception {
        return args -> {

//            workflow.testOwnerGetAllOwners();
//            workflow.testPetGetAllPets();
//            workflow.testVisitGetAllVisits();
//            workflow.testVetGetAllVets();
//            workflow.testOwnerAddOwner();
//            workflow.testPetAddPet();
//            workflow.testPetGetPet(7L);
        };
    }
}