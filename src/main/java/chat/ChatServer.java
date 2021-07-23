package chat;

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
    private EventLoopGroup boss;
    private EventLoopGroup work;
    private void run() throws InterruptedException {
        boss=new NioEventLoopGroup();
        work=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("encoder", new StringDecoder());
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast(null);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
    @PostConstruct
    public void init(){
        new Thread(()->{
            try {
                run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    @PreDestroy
    public void destroy() throws InterruptedException {
        if(boss!=null){
            boss.shutdownGracefully().sync();
        }
        if(work!=null){
            work.shutdownGracefully().sync();
        }
    }
}
