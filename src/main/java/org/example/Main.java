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
    private static final String Signing = "1653988ebd51184492c16e6108d431cf";
    private static Slack slack = Slack.getInstance();
    //private static List<LayoutBlock> layoutBlocks = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // App expects env variables (SLACK_BOT_TOKEN, SLACK_SIGNING_SECRET)
//        App app = new App();
//
//        app.command("/hello", (req, ctx) -> {
//            return ctx.ack(":wave: Hello!");
//        });
//
//        SlackAppServer server = new SlackAppServer(app);
//        server.start(); // http://localhost:3000/slack/events


        /*
        layoutBlocks.add(section(section -> section.text(markdownText("새로운 의견이 등록되었습니다."))));
        layoutBlocks.add(divider());
        layoutBlocks.add(
                actions(actions -> actions
                        .elements(asElements(
                                button(b -> b.text(plainText(pt -> pt.emoji(true).text("승인")))
//                                        .value(deliveryTip.getSeq().toString())
                                        .style("primary")
                                        .actionId("action_approve")
                                ),
                                button(b -> b.text(plainText(pt -> pt.emoji(true).text("거부")))
//                                        .value(deliveryTip.getSeq().toString())
                                        .style("danger")
                                        .actionId("action_reject")
                                )
                        ))
                )
        );

         */

//        layoutBlocks.add(section(section -> section.text(markdownText("안녕하세요! \n 슬랙봇입니다:)"))));
//        layoutBlocks.add(divider());
//        layoutBlocks.add(
//                actions(actions -> actions
//                        .elements(asElements(
//                                checkboxes(c->c.options(
//                                        text.plainText(pt -> pt.emoji(true).text("업무 완료")),
//                                        plainText(pt -> pt.emoji(true).text("진행 중"))
//                                ).actionId("actionID-0"))
//                        )))
//        )

        try {

            ChatPostMessageResponse response;
            response = slack.methods(Token).chatPostMessage(req -> req
                    .channel("C04FHJY8D63")
//                    .text("안녕하세요")
//                    .blocks(layoutBlocks)
                            .blocksAsString(
                                    "[\n" +
                                            "\t\t{\n" +
                                            "\t\t\t\"type\": \"section\",\n" +
                                            "\t\t\t\"text\": {\n" +
                                            "\t\t\t\t\"type\": \"mrkdwn\",\n" +
                                            "\t\t\t\t\"text\": \"안녕하세요! \\n 슬랙봇입니다:)\\n\"\n" +
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
                                            "\t\t\t\"alt_text\": \"돋보기\"\n" +
                                            "\t\t}\n" +
                                            "\t]")
                    );

            if (response.isOk()){
                Message postedMessage = response.getMessage();
                System.out.println("전송 성공");

//                app.blockAction("actionId-2", (req, ctx) -> {
//                    String value = req.getPayload().getActions().get(0).getValue(); // "button's value"
//                    if (req.getPayload().getResponseUrl() != null) {
//                        // Post a message to the same channel if it's a block in a message
//                        ctx.respond("You've sent " + value + " by clicking the button!");
//                    }
//                    return ctx.ack();
//                });
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

