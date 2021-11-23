package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class clientChuHoa {
	public static void menu( ) {
		System.out.println("1. Viet hoa chuoi");
		System.out.println("2. Dao chuoi");
		System.out.println("3. Dem tu");
		System.out.println("0. Ket thuc chuong trinh");
		
	}
public static void main(String[]args) {
	System.out.println("Client dang khoi dong");
	System.out.println("--------------Menu--------------");
	Scanner scn= new Scanner(System.in);
	try {
		Chuoi ch=(Chuoi) Naming.lookup("rmi://localhost:9999/Mychuoi");
		menu();
		System.out.println("Nhap thao tac can thuc hien");
		int chon= scn.nextInt();
		System.out.println("----------------------------");
		while(chon>0) {
			switch(chon) {
			case 1:
				System.out.println("Nhap chuoi can viet hoa:");
				scn.nextLine();
				String s=scn.nextLine();
				System.out.println("Chuoi viet hoa la:"+ ch.chuoiHoa(s));
				break;

			case 2:
				System.out.println("Nhap chuoi can dao nguoc:");
				scn.nextLine();
				String s2=scn.nextLine();
				System.out.println("Chuoi bi dao la:"+ ch.daoChuoi(s2));
				break;
			case 3:
				System.out.println("Nhap chuoi can dem ki tu:");
				scn.nextLine();
				String s3=scn.nextLine();
				System.out.println("So ky tu co trong chuoi:"+ ch.demKiTu(s3));
				break;
			case 0:
				System.out.println("Ket thuc chuong trinh!!!:");
				break;
				default: 
					System.err.println("Nhap thao tac sai!!!");
					break;
				
			}
			System.out.println("-------------Chao ban----------------");
			menu();
			System.out.println("Moi ban nhap thao tac can thuc hien:");
			chon=scn.nextInt();
		}
	}catch (MalformedURLException | RemoteException | NotBoundException e) {
		
		 e.printStackTrace();
	}
}
    
}