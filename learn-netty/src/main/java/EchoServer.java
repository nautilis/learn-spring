import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;


/**
 * @author: zpf
 * 1.绑定到服务器监听的端口
 * 2.配置Channel,将入站消息通知给EchoServerHandler实例
 **/
public class EchoServer {
    private final int port;
    public EchoServer(int port) {
        this.port = port;
    }
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " <port>");
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class) /*指定所使用的NIO传输Channel*/
                    .localAddress(new InetSocketAddress(port)) /*指定端口套接字地址*/
                    .childHandler(new ChannelInitializer<SocketChannel>(){ /*⑤添加业务handler 到子ChannelHandler的ChannelPipeline*/
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture f = b.bind().sync(); /*绑定服务器，同步阻塞直到完成*/
            f.channel().closeFuture().sync(); /*获取channel的CloseFuture阻塞直到完成*/
        } finally {
            group.shutdownGracefully().sync(); /*关闭EventLoopCroup释放所有资源*/
        }
    }
    /**
     * ⑤ 在 处，你使用了一个特殊的类——ChannelInitializer。这是关键。当一个新的连接
     * 被接受时，一个新的子 Channel 将会被创建，而 ChannelInitializer 将会把一个你的
     * EchoServerHandler 的实例添加到该 Channel 的 ChannelPipeline 中。
     */

}
