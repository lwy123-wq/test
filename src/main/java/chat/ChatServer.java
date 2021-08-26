package chat;

import chat.Initializer.ChatServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ChatServer{

    private EventLoopGroup bossGroup;
    private EventLoopGroup workGroup;

    private void run() throws Exception {
        // log.info("开始启动聊天服务器");
        bossGroup = new NioEventLoopGroup(1);
        workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());
            //启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            //log.info("开始启动聊天服务器结束");
            channelFuture.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    /**
     * 初始化服务器
     */
    @PostConstruct()
    public void init() {
        new Thread(() -> {
            try {
                run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


    @PreDestroy
    public void destroy() throws InterruptedException {
        if (bossGroup != null) {
            bossGroup.shutdownGracefully().sync();
        }
        if (workGroup != null) {
            workGroup.shutdownGracefully().sync();
        }
    }
}


//.childHandler(new ChannelInitializer<SocketChannel>() {
//
//@Override
//protected void initChannel(SocketChannel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new ChatServerInitializer());
////                            pipeline.addLast("encoder", new StringDecoder());
////                            pipeline.addLast("decoder", new StringDecoder());
//
//        }
//        });