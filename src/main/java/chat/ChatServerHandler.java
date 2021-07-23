package chat;

import chat.config.ChatConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;

import java.time.LocalDateTime;

public class ChatServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    final User user=new User();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String text=msg.text();
        JSONObject jsonObject= JSON.parseObject(text);
        Object ss=jsonObject.get("msg");
        String userId=(String) jsonObject.get("userid");
        Channel channel=ctx.channel();
        if(ss==null){
            //TODO
            register(userId,channel);
        }else {
            //TODO
            send(ss,userId);
        }
    }
    private void register(String userId,Channel channel){
        if(!ChatConfig.concurrentHashMap.containsKey(userId)){
            ChatConfig.concurrentHashMap.put(userId,channel);
            AttributeKey<String> key=AttributeKey.valueOf("userid");
            channel.attr(key).setIfAbsent(userId);
        }
    }
    private void send(Object ss,String userid){
        Channel channel1=ChatConfig.concurrentHashMap.get(userid);
        if(channel1!=null){
            channel1.writeAndFlush(new TextWebSocketFrame("服务器时间" + LocalDateTime.now() + " " +ss));
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded 被调用" + ctx.channel().id().asLongText());
    }
    private void removeUserId(ChannelHandlerContext ctx){
        Channel channel=ctx.channel();
        AttributeKey<String> key=AttributeKey.valueOf("userid");
        String userid=channel.attr(key).get();
        ChatConfig.concurrentHashMap.remove(userid);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        removeUserId(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
