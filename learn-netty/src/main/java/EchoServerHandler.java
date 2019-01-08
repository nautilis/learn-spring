import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: zpf
 * ChannleHandler
 * 1.针对不同类型的事件来调用 ChannelHandler；
 * 2.应用程序通过实现或者扩展 ChannelHandler 来挂钩到事件的生命周期，并且提供自
 * 定义的应用程序逻辑；
 * 3.在架构上，ChannelHandler 有助于保持业务逻辑与网络处理代码的分离。这简化了开
 * 发过程，因为代码必须不断地演化以响应不断变化的需求。
 **/
@ChannelHandler.Sharable /*标志handler可被多个channel安全共享*/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        System.out.println(
                "Server received: " + in.toString(CharsetUtil.UTF_8));
        ctx.write(in); /*接收到的消息写给发送者， 不冲刷出站消息*/
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) /*将未决消息写给发送者，并关闭该channel*/
                .addListener(ChannelFutureListener.CLOSE);
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
