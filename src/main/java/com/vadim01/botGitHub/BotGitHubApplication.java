package com.vadim01.botGitHub;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class BotGitHubApplication {

    private static Logger logger = LoggerFactory.getLogger(BotGitHubApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BotGitHubApplication.class, args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    @PostMapping("/botGitHub")
    public String botGitHub(@RequestBody String request) {
        try {
            logger.info("Try parse request to json");
            JSONObject jsonObject = new JSONObject(request);
            if (jsonObject.get("type").equals("confirmation")) {
                logger.info("return CONFIRMATION");
                return "def1e8de";
            }
        } catch (JSONException e) {
            logger.error("problem with parse");
            logger.error(e.getMessage());
        }
        return "ok";
    }

}
