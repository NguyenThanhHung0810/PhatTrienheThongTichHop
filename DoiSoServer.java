package QuyDoiSo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DoiSoServer {
	public static final int port = 8881;
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(port);
	Socket socket = serverSocket.accept();
	DataOutputStream os = new DataOutputStream(socket.getOutputStream());
	DataInputStream is =new DataInputStream(socket.getInputStream());
	while(true) {
		String mess = is.readUTF();
		String send = "";
		switch (mess) {
		case "0":
			send ="Khong";
			break;
		case "1":
			send ="Mot";
			break;
		case "2":
			send ="Hai";
			break;
		case "3":
			send ="Ba";
			break;
		case "4":
			send ="Bon";
			break;
		case "5":
			send ="Nam";
			break;
		case "6":
			send ="Sau";
			break;
		case "7":
			send ="Bay";
			break;
		case "8":
			send ="Tam";
			break;
		case "9":
			send ="Chin";
			break;

		default:
			send ="Khong phai so nguyen";
			break;
		}
		os.writeUTF(send);
	}
}
}