package ChatRoom;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class chatServer {
    private int port;
    public static ArrayList<Socket> ListSK;

    public chatServer(int port){
        this.port = port;
    }

    private void execute() throws IOException{
        ServerSocket server = new ServerSocket(port);
        WriteServer write = new WriteServer();
        write.start();
        System.out.println("Server đã được kết nối !!!");
        while(true){
            Socket socket = server.accept();
            System.out.println("Server đã được kết nối với " + socket);
            chatServer.ListSK.add(socket);
            ReadServer read = new ReadServer(socket);
            read.start();
        }
    }

    public static void main(String[] args) throws IOException {
        chatServer.ListSK = new ArrayList<>();
        chatServer server = new chatServer(9999);
        server.execute();
    }
}

class ReadServer extends Thread{
    private Socket socket;

    public ReadServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        DataInputStream dis = null;
        try{
            dis = new DataInputStream(socket.getInputStream());
            while(true){
                String sms = dis.readUTF();
                if(sms.contains("exit")){
                    chatServer.ListSK.remove(socket);  
                    System.out.println("Đã ngắt kết nối với" + socket);
                    dis.close();
                    socket.close();
                    continue; // kết thúc toàn bộ chương trình
                }
                for(Socket item : chatServer.ListSK){
                    if(item.getPort() != socket.getPort()){
                        DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                        dos.writeUTF(sms);
                    }
                }
                System.out.println(sms);
            }
        }catch(Exception e){
            try{
                socket.close();
            }catch(IOException ex){
                System.out.println("Ngắt kết nối Server !!!");
            }
            
        }
    }
}

class WriteServer extends Thread{

    @Override
    public void run(){
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);
        while(true){
            String sms = sc.nextLine();
            try{
                for(Socket item : chatServer.ListSK){//duyệt một mản trong phần tử có tên là item
                    dos = new DataOutputStream(item.getOutputStream());
                    dos.writeUTF("Server: " + sms);
                }
            }catch(IOException ex){
                    System.out.println("Ngắt kết nối Server !!!");
                }
                
            }
    }

}

