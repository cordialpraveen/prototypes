package com.wedaa.notes.notification.web.rest.comm;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ServerResource {

    private final Logger log = LoggerFactory.getLogger(ServerResource.class);

    @GetMapping("/services/notification")
    public Mono<ResponseEntity<Map<String, String>>> getServer() {
        log.info("This is Server notification");
        Map<String, String> serverMap = new HashMap<>();
        serverMap.put("server", "This is Server notification");
        return Mono.just(ResponseEntity.ok(serverMap));
    }
}
