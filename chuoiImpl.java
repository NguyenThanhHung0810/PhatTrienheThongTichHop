package RMI;


import java.rmi.*;

public class chuoiImpl implements Chuoi{
    public static final char SPACE = '\t';
    public static final char tab = '\t';
	public static final char BREAK_LINE = '\n';
	
public String chuoiHoa(String s) throws RemoteException{
	return s.toUpperCase();

}

public String daoChuoi(String s) throws RemoteException{
	String daoChuoi = new StringBuffer(s).reverse().toString();
	return daoChuoi;
}
public int demKiTu(String s) throws RemoteException{
	if(s==null) {
		return -1;
	}
	int count = 0;
	int size = s.length();
	boolean notCounted = true;
	for(int i =0; i<size;i++) {
		if(s.charAt(i) != SPACE && s.charAt(i) != tab &&s.charAt(i) != BREAK_LINE) {
			if(notCounted) {
				count++;
				notCounted = false;
			}
			else {
				notCounted =true;
			}
		}
		return count;
	}
	return size;
}
}