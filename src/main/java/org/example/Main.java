package org.example;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    private static final String Token = "xoxb-1376359396183-4555396726737-OGvVgYlP2HI5alnqM1dLvJ5f";
    private String msg = "";
    private static Slack slack = Slack.getInstance();
    private static List<Content> list = new ArrayList<>();
    //private static String token = System.getenv("xoxb-1376359396183-4555396726737-OGvVgYlP2HI5alnqM1dLvJ5f");

    public static void main(String[] args){

        try {
            ChatPostMessageResponse response;
            response = slack.methods(Token).chatPostMessage(req -> req
                    .channel("C04ESJJTZ5E")
                    .text("안녕하세요")
                    .blocks(list));

            if (response.isOk()){
                Message postedMessage = response.getMessage();
                System.out.println("전송 성공");
            }
            else {
                String errorCode = response.getError();
                System.out.println("전송 실패: " + errorCode);
            }
        }catch (SlackApiException requestFailure){
            System.out.println("전송 실패: " + requestFailure.getMessage());
        }catch (IOException connectivityIssue){
            System.out.println("전송 실패: " + connectivityIssue.getMessage());
        }

//        msg = "안녕하세요!";
        /*
        try {
            send();
            System.out.println("전송 성공");
        } catch (Exception e) {
            System.out.println("전송 실패 : " + e.getMessage());
            throw new RuntimeException(e);
        }

         */
    }

    /*
    public static void send() throws Exception {
        String url = "https://slack.com/api/chat.postMessage?";
        url += "token=xoxb-1376359396183-4541956097106-IXi4bjYNVz6A8czFOYjPfkD0";
        url += "&";
        url += "channel=C04FHJY8D63";
        url += "&";
        url += "text=" + URLEncoder.encode("Hello", "UTF-8");
        url += "&";
        url += "pretty=1";

        HttpURLConnection connection = null;
        URL urlStr = new URL(url);
        connection = (HttpURLConnection) urlStr.openConnection();
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestMethod("GET");
        connection.connect();
        new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
    }
    */


//    public static WebhookResponse send(String msg) {
//        try{
//
//            WebhookResponse response = null;
//            Slack slack = Slack.getInstance();
//            Payload payload = Payload.builder().text(msg).build();
//            response = slack.send(webHook, payload);
//            return response;
//
//        } catch (IOException e) {
//            log.error("error : " + e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
}

