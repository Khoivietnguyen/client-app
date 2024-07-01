package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
	
	@Value("${vpn.server.addr}")
    private String vpnServerAddress;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callServer/{serverId}")
    public String callServer(@PathVariable String serverId) {
//        String serverUrl = "http://localhost:8081/startVpn";
        return restTemplate.getForObject(vpnServerAddress+serverId+":8080/startVpn", String.class);
    }
}

