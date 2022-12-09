package org.example;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {

    private static final String webHook = "https://hooks.slack.com/services/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";

    public static void main(String[] args){
        send("안녕하세요!😊");
    }

    public static WebhookResponse send(String msg) {
        try{

            WebhookResponse response = null;
            Slack slack = Slack.getInstance();
            Payload payload = Payload.builder().text(msg).build();
            response = slack.send(webHook, payload);
            return response;

        } catch (IOException e) {
            log.error("error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

