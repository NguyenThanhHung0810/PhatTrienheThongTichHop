package RMI;

import java.rmi.*;

public interface Chuoi extends Remote{
	public String chuoiHoa(String s) throws RemoteException;
	public String daoChuoi(String s) throws RemoteException;
	public int demKiTu(String s) throws RemoteException;
}