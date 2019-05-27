package ppoo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
public class filechannelread {
    public static void main(String[] args) throws IOException {		
        Path path = Paths.get("C:/Temp/file.txt");
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        Charset charset = Charset.defaultCharset();
        String data = "";
        int byteCount;
        while(true) {
            byteCount = fileChannel.read(byteBuffer);
            if(byteCount == -1) break;
            byteBuffer.flip();
            data += charset.decode(byteBuffer).toString();
            byteBuffer.clear();
        }
        fileChannel.close();
        System.out.println("file.txt : " + data);
    }
}

