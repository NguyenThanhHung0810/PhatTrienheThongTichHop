package UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public final static int serverPort = 7;
    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket(serverPort);
            System.out.println("Server Created ... ");
            byte[] buffer = new byte[6000];
            while(true){
                DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
                ds.receive(incoming);//cho nhan goi tin goi den
                //lay du lieu khoi goi tin nhan và doi tu mang byte ra chuoi
                String theString = new String(incoming.getData(),0,incoming.getLength());
                //tao goi tin chua du lieu vua va nhan duoc
                DatagramPacket outsending = new DatagramPacket(theString.getBytes(), incoming.getLength(), incoming.getAddress(), incoming.getPort());
                ds.send(outsending);
            }
        }catch(IOException ie){
            System.out.println(ie);
        }
    }
}
