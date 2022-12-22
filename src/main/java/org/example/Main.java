package org.example;

import com.slack.api.Slack;
import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.Message;
import com.slack.api.model.block.LayoutBlock;
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

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;
import static com.slack.api.model.block.composition.BlockCompositions.plainText;
import static com.slack.api.model.block.element.BlockElements.*;

@Slf4j
public class Main {

    private static final String Token = "xoxb-1376359396183-4555396726737-OGvVgYlP2HI5alnqM1dLvJ5f";
    private static Slack slack = Slack.getInstance();

    public static void main(String[] args) {

        try {

            ChatPostMessageResponse response;
            response = slack.methods(Token).chatPostMessage(req -> req
                    .channel("C04FHJY8D63")
//                    .text("안녕하세요")
                            .blocksAsString(
                                    "[\n" +
                                            "\t\t{\n" +
                                            "\t\t\t\"type\": \"section\",\n" +
                                            "\t\t\t\"text\": {\n" +
                                            "\t\t\t\t\"type\": \"mrkdwn\",\n" +
                                            "\t\t\t\t\"text\": \"안녕하세요! \\n 슬랙봇입니다:)\"\n" +
                                            "\t\t\t},\n" +
                                            "\t\t\t\"accessory\": {\n" +
                                            "\t\t\t\t\"type\": \"image\",\n" +
                                            "\t\t\t\t\"image_url\": \"https://pbs.twimg.com/profile_images/625633822235693056/lNGUneLX_400x400.jpg\",\n" +
                                            "\t\t\t\t\"alt_text\": \"cute cat\"\n" +
                                            "\t\t\t}\n" +
                                            "\t\t},\n" +
                                            "\t\t{\n" +
                                            "\t\t\t\"type\": \"context\",\n" +
                                            "\t\t\t\"elements\": [\n" +
                                            "\t\t\t\t{\n" +
                                            "\t\t\t\t\t\"type\": \"plain_text\",\n" +
                                            "\t\t\t\t\t\"text\": \"↓↓↓\",\n" +
                                            "\t\t\t\t\t\"emoji\": true\n" +
                                            "\t\t\t\t}\n" +
                                            "\t\t\t]\n" +
                                            "\t\t},\n" +
                                            "\t\t{\n" +
                                            "\t\t\t\"type\": \"section\",\n" +
                                            "\t\t\t\"text\": {\n" +
                                            "\t\t\t\t\"type\": \"mrkdwn\",\n" +
                                            "\t\t\t\t\"text\": \":thumbsup: *굵은 글씨*, and ~삭제~, and <https://naver.com|네이버 페이지로 이동>\"\n" +
                                            "\t\t\t}\n" +
                                            "\t\t},\n" +
                                            "\t\t{\n" +
                                            "\t\t\t\"type\": \"image\",\n" +
                                            "\t\t\t\"image_url\": \"https://i1.wp.com/thetempest.co/wp-content/uploads/2017/08/The-wise-words-of-Michael-Scott-Imgur-2.jpg?w=1024&ssl=1\",\n" +
                                            "\t\t\t\"alt_text\": \"inspiration\"\n" +
                                            "\t\t}\n" +
                                            "\t]")
                    );

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
    }

}

