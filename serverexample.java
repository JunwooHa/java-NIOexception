package ppoo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
public class serverexample {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);		
            serverSocketChannel.bind(new InetSocketAddress(5001));
            while(true) {
	System.out.println( "[���� ��ٸ�]");
	SocketChannel socketChannel = serverSocketChannel.accept();
	InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
	System.out.println("[���� ������] " + isa.getHostName());
            }
        } catch(Exception e) {}
        if(serverSocketChannel.isOpen()) {
            try {
	serverSocketChannel.close();
            } catch (IOException e1) {}
        }
    }
}

