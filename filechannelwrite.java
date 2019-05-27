package askd;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
public class filechannelwrite {
    public static void main(String[] args) throws IOException {		
        Path path = Paths.get("C:/Temp/file.txt");
        Files.createDirectories(path.getParent());
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, 
	StandardOpenOption.WRITE);
        String data = "æ»≥Á«œººø‰";
        Charset charset = Charset.defaultCharset();
        ByteBuffer byteBuffer = charset.encode(data);
		
        int byteCount = fileChannel.write(byteBuffer);
        System.out.println("file.txt : " + byteCount + " bytes written");
		
        fileChannel.close();
    }
}

