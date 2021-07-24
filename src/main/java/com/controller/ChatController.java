package com.controller;

import chat.config.ChatConfig;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    @PostMapping("/chat")
    public String chat(Model model, @RequestParam("userid") String userid, @RequestParam("sendid") String sendid) {
        model.addAttribute("userid",userid);
        model.addAttribute("sendid",sendid);
        return "chat";
    }
    @PostMapping("/send")
    public String chat(@RequestParam("sendid") String sendid) throws InterruptedException {
        while (true){
            Channel channel= ChatConfig.concurrentHashMap.get(sendid);
            if(channel!=null){
                channel.writeAndFlush(new TextWebSocketFrame("test"));
                Thread.sleep(1000);
            }

        }
    }

}
