package ChuHoa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class FileServerChuHoa {
    public final static int port = 8;
    
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server created...");
            while(true) {
                Socket s = ss.accept();
                System.out.println("Client " + s.getRemoteSocketAddress() + " connected");
                RequestProcesing rp = new RequestProcesing(s);
                rp.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
