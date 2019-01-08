import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author: zpf
 * 1.channelActive()——在到服务器的连接已经建立之后将被调用；
 * 2.channelRead0当从服务器接收到一条消息时被调用
 * 3.exceptionCaught在处理过程中引发异常时被调用。
 **/
@ChannelHandler.Sharable
public class EchoClientHandler extends
        SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",
                CharsetUtil.UTF_8)); /*当被通知channel是活跃时发一条消息*/
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println(
                "Client received: " + in.toString(CharsetUtil.UTF_8)); /*记录已转收的消息*/
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
