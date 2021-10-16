package UngDungChat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			s = new Socket("localhost", 2000);
			System.out.println("Client is connecting....");
			
			Scanner sc = new Scanner(System.in);
			String str;
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			
			while(true)
			{
				System.out.print("Client : ");
				str = sc.nextLine();
				dos.writeUTF(str);
				
				String ch = dis.readUTF();
				System.out.print("Server :"+ch+"\n");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			dos.close();
            dis.close();
            s.close();
            e.printStackTrace();
			System.out.print("ket thuc");
		}
	}

}
