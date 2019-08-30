package com.example.petclinic.client.workflow;

import com.example.petclinic.client.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ClientWorkflow {

    private static final Logger log = LoggerFactory.getLogger(ClientWorkflow.class.getName());

    private RestTemplate restTemplate;

    public ClientWorkflow(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void testOwnerGetAllOwners() {
        List<LinkedHashMap<String, String>> objects = restTemplate.getForObject("http://localhost:8080/owner/getAllOwners", List.class);

        // Need to map our list of HashMaps to a list of Owners
        ObjectMapper mapper = new ObjectMapper();

        List<Owner> owners = mapper.convertValue(objects, new TypeReference<List<Owner>>() {
        });

        owners.forEach(owner -> log.info(owner.toString()));
    }

    public void testOwnerAddOwner() {
        Owner testOwner = Owner.builder().withName("Doug").withAddress("123 Test St.").withCity("None").withPhoneNumber("123-456-4321").build();

        HttpEntity<Owner> request = new HttpEntity<>(testOwner);
        restTemplate.postForObject("http://localhost:8080/owner/addOwner", request, Owner.class);
    }

    public void testPetGetAllPets() {
        List<LinkedHashMap<String, String>> objects = restTemplate.getForObject("http://localhost:8080/pet/getAllPets", List.class);

        // Need to map our list of HashMaps to a list of Owners
        ObjectMapper mapper = new ObjectMapper();

        List<Pet> pets = mapper.convertValue(objects, new TypeReference<List<Pet>>() {
        });

        pets.forEach(pet -> log.info(pet.toString()));
    }

    public void testPetAddPet() {
        Pet testPet = Pet.builder().withName("Diggy").withPetType(PetType.LOBSTER).withBirthDate(new Date()).build();

        HttpEntity<Pet> request = new HttpEntity<>(testPet);
        restTemplate.postForObject("http://localhost:8080/pet/addPet", request, Pet.class);
    }

    public void testPetGetPet(Long id) {

        StringBuilder builder = new StringBuilder();
        builder.append("http://localhost:8080/pet/getPet/").append(id);

        String url = builder.toString();

        Pet pet = restTemplate.getForObject(url, Pet.class);

        log.info(pet.toString());
    }

    public void testVisitGetAllVisits() {
        List<LinkedHashMap<String, String>> objects = restTemplate.getForObject("http://localhost:8080/visit/getAllVisits", List.class);

        // Need to map our list of HashMaps to a list of Owners
        ObjectMapper mapper = new ObjectMapper();

        List<Visit> visits = mapper.convertValue(objects, new TypeReference<List<Visit>>() {
        });

        visits.forEach(visit -> log.info(visit.toString()));
    }

    public void testVetGetAllVets() {
        List<LinkedHashMap<String, String>> objects = restTemplate.getForObject("http://localhost:8080/vet/getAllVets", List.class);

        // Need to map our list of HashMaps to a list of Owners
        ObjectMapper mapper = new ObjectMapper();

        List<Vet> vets = mapper.convertValue(objects, new TypeReference<List<Vet>>() {
        });

        vets.forEach(vet -> log.info(vet.toString()));
    }
}