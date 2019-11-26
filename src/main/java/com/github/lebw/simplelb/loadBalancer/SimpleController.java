package com.github.lebw.simplelb.loadBalancer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author LBW
 */
@Controller
public class SimpleController {

    private final BackEnds backEnds;

    public SimpleController(BackEnds backEnds) {
        this.backEnds = backEnds;
    }

    @GetMapping("/")
    public ResponseEntity<String> getRequest() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(backEnds.getNextBackEnd().getUrl(), String.class);
            return response;
        } catch (RestClientException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
            return response;
        }
    }
}
