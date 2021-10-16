package UngDungChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	private static ServerSocket ss = null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ss = new ServerSocket(2000);
		System.out.println("Server is connecting....");
		
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			s = ss.accept();

			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				String str = dis.readUTF();
				System.out.print("Client : " + str + "\n");

				System.out.print("Server : ");
				String mess = sc.nextLine();
				dos.writeUTF(mess);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			dos.close();
	        dis.close();
			ss.close();
	        System.out.print(e);
		}
		

	}

}
