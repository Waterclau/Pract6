package com.icai.practicas;
import com.icai.practicas.controller.ProcessController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControlerTest {
    
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void given_app_when_login_using_right_credentials_then_ok() {
    
    //Link
    String address = "http://localhost:" + port + "/api/v1/process-step1";
    //Lo que pasamos al contolador -> multivaluemap
    String fullNameRaw = "Claudio Esteban";
    String dniRaw = "06679111A";
    String telefonoRaw = "679224814";

    ProcessController.DataRequest data1 = new ProcessController.DataRequest(fullNameRaw, dniRaw, telefonoRaw);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data1, headers);
    
    ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void given_app_when_login_using_right_credentials_then_ok_legacy() {

        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";

        //Test donde debe funcionar correctamente
        MultiValueMap<String, String> data1 = new LinkedMultiValueMap<>();
        data1.add("fullName", "Claudio Esteban");
        data1.add("dni", "06679111A");
        data1.add("telefono", "679224814");

        //Test donde el nombre es incorrecto
        MultiValueMap<String, String> data2 = new LinkedMultiValueMap<>();
        data2.add("fullName", "Paquito$$23");
        data2.add("dni", "53938791L");
        data2.add("telefono", "679224814");

        //Test donde el DNI es incorrecto 
        MultiValueMap<String, String> data3 = new LinkedMultiValueMap<>();
        data3.add("fullName", "Claudio Esteban");
        data3.add("dni", "000000000078");
        data3.add("telefono", "679224814");

        //Test donde el numero del telefono es incorrecto
        MultiValueMap<String, String> data4 = new LinkedMultiValueMap<>();
        data3.add("fullName", "Claudio Esteban");
        data3.add("dni", "06679111A");
        data3.add("telefono", "ABCDEFGHI");


        // Construimos el request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

      
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data1, headers);
        HttpEntity<MultiValueMap<String, String>> request_2 = new HttpEntity<>(data2, headers);
        HttpEntity<MultiValueMap<String, String>> request_3 = new HttpEntity<>(data3, headers);
        HttpEntity<MultiValueMap<String, String>> request_4 = new HttpEntity<>(data3, headers);
      

        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);
        ResponseEntity<String> result_2 = this.restTemplate.postForEntity(address, request_2, String.class);
        ResponseEntity<String> result_3 = this.restTemplate.postForEntity(address, request_3, String.class);
        ResponseEntity<String> result_4 = this.restTemplate.postForEntity(address, request_4, String.class);

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result_2.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result_3.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result_4.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}




        
