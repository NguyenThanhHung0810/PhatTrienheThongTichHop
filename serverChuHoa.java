package RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class serverChuHoa {

	    public static void main(String[] args) throws MalformedURLException, AlreadyBoundException{
	     System.out.println("Server dang khoi dong ");
	     int port=9999;
	     try {
	    	 LocateRegistry.createRegistry(port);
	    	 chuoiImpl ch = new chuoiImpl();
	    	 UnicastRemoteObject.exportObject(ch,port);
	    	 Naming.bind("rmi://localhost:9999/Mychuoi", ch);
	    	 System.out.println("server da ket noi");
	     }catch (RemoteException e) {
	    	 e.printStackTrace();
	     }
	    }
}