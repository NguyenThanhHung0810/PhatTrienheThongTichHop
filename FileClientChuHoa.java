package ChuHoa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class FileClientChuHoa {
    public final static int port = 8;
    public final static String IP = "127.0.0.1";

    public static void main(String[] args) {
        Socket s= null;
        try {
            s = new Socket(IP, port);
            System.out.println("Client already...");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            DataInputStream dis = new DataInputStream(is);

            Scanner sc = new Scanner(System.in);
            String tempS;
            String filename;
            int temp;
            while(true) {
                if(s.isClosed()) break;
                tempS = dis.readUTF();
                System.out.println("\n" + tempS);
                temp = sc.nextInt();
                os.write(temp);
                
                switch(temp) {
                    case 1: {
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS);
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS + "---> ");
                        sc.nextLine();
                        filename = sc.nextLine();
                        dos.writeUTF(filename);
                        tempS = dis.readUTF();
                        System.out.println(" Server: \n" + tempS);
                        break;
                    }
                    case 2: {
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS);
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS + "---> ");
                        sc.nextLine();
                        filename = sc.nextLine();
                        dos.writeUTF(filename);
                        tempS = dis.readUTF();
                        System.out.println(" Server: \n" + tempS);
                        break;
                    }

                    case 3: {
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS);
                        tempS = dis.readUTF();
                        System.out.print("Server: " + tempS + "---> ");
                        sc.nextLine();
                        filename = sc.nextLine();
                        dos.writeUTF(filename);
                        tempS = dis.readUTF();
                        System.out.println(" Server: \n" + tempS);
                        break;
                    }

                    case 4: {
                        tempS = dis.readUTF();
                        System.out.println(tempS);
                        s.close();
                        break;
                    }
                    
                    default : {
                        tempS = dis.readUTF();
                        System.out.println(tempS);
                        s.close();
                        break;
                    }
                }
            }
            is.close();
            os.close();
            dos.close();
            dis.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

}
