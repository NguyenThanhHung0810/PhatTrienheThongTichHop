package TCPSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessing extends Thread {
    Socket channel; // socket cua kenh ao noi voi clinet hien tai
    public RequestProcessing(Socket s){
        channel = s; // nhan socket cua kenh ao noi voi client
    }

    public void run(){
        try{
            OutputStream os = channel.getOutputStream();
            InputStream is = channel.getInputStream();
            while(true){
                int n = is.read();
                if(n==-1) break;
                os.write(n);
                //
            }
        }catch(IOException ie){
            System.out.println("Request Processing Error: "+ie);
        }
    }
}
