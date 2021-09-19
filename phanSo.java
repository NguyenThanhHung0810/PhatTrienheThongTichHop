

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class phanSo {

	int tu, mau;

	public phanSo() // ham khoi tao khong tham so
	{
		tu = 0;
		mau = 1;
	}

	public phanSo(int x) // khoi tao mot tham so
	{
		tu = x;
		mau = 1;
	}

	public phanSo(int a, int b) // khoi tao hai tham so
	{
		tu = a;
		mau = b;
	}

	public void XuatPhanSo() // Xuat phan so
	{
		System.out.println(tu + "/" + mau);
	}

	public void NghichDaoPS() {
		System.out.println(mau + "/" + tu);
	}

	public double GiaTriThuc() {
		return (tu / mau);
	}

	public phanSo CongPS(phanSo ps10) // tong cua 2 phan so
	{
		int ts = tu * ps10.mau + mau * ps10.tu;
		int ms = mau * ps10.mau;
		phanSo ketqua = new phanSo(ts, ms);
		return (ketqua);
	}

	public phanSo TruPS(phanSo ps1) {
		int ts = tu * ps1.mau - mau * ps1.tu;
		int ms = mau * ps1.mau;
		phanSo ketqua = new phanSo(ts, ms);
		return (ketqua);
	}

	public phanSo NhanPS(phanSo ps1) {
		int ts = tu * ps1.tu;
		int ms = mau * ps1.mau;
		phanSo ketqua = new phanSo(ts, ms);
		return (ketqua);
	}

	public phanSo ChiaPS(phanSo ps1) {
		int ts = tu * ps1.mau;
		int ms = mau * ps1.tu;
		phanSo ketqua = new phanSo(ts, ms);
		return (ketqua);
	}

	public phanSo RutGon() {
		int ts = tu;
		int ms = mau;
		while (tu != mau) {
			if (tu > mau)
				tu = tu - mau;
			else
				mau = mau - tu;
		}
		ts = ts / tu;
		ms = ms / tu;
		phanSo ketqua = new phanSo(ts, ms);
		return (ketqua);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader d1 = new BufferedReader(new InputStreamReader(System.in));

		String e;
		int chon, a, d, c;
		phanSo ps = new phanSo();
		phanSo ps1 = new phanSo(3, 5);
		phanSo ps2 = new phanSo(15, 4);

		System.out.println("Phan so thu nhat = ");
		ps1.XuatPhanSo();

		System.out.println("Phan so thu hai = ");
		ps2.XuatPhanSo();

		do {
			System.out.println("MENU");
			System.out.println("1.Tong");
			System.out.println("2.Hieu");
			System.out.println("3.Tich");
			System.out.println("4.Thuong");
			System.out.println("5.Xuat gia tri thuc phan so");
			System.out.println("6.Nghich dao phan so");
			System.out.println("7.Rut gon phan so");

			e = d1.readLine();
			chon = Integer.parseInt(e);

			switch (chon) {
			case 1: {
				ps = ps1.CongPS(ps2);
				System.out.println("Tong cua hai phan so : ");
				ps.RutGon();
				ps.XuatPhanSo();
				break;
			}
			case 2: {
				ps = ps1.TruPS(ps2);
				System.out.println("Hieu cua hai phan so :");
				ps.XuatPhanSo();
				break;
			}
			case 3: {
				ps = ps1.NhanPS(ps2);
				System.out.println("Tich cua hai phan so :");
				ps.XuatPhanSo();
				break;
			}
			case 4: {
				ps = ps1.ChiaPS(ps2);
				System.out.println("Thuong cua hai phan so :");
				ps.XuatPhanSo();
				break;
			}
			case 5: {
				System.out.println("Gia tri thuc cua phan so 1 la: ");
				System.out.println(ps1.GiaTriThuc());

				System.out.println("Gia tri thuc cua phan so 2 la: ");
				System.out.println(ps2.GiaTriThuc());
				break;
			}
			case 6: {
				System.out.println("Nghich dao cua phan so 1 la: ");
				ps1.NghichDaoPS();

				System.out.println("Nghich dao cua phan so 2 la: ");
				ps2.NghichDaoPS();
				break;
			}
			case 7: {
				System.out.println("Phan so can rut gon: ");
				ps1.XuatPhanSo();
				ps = ps1.RutGon();
				System.out.println("Phan so sau khi rut gon: ");
				ps.XuatPhanSo();
				break;
			}
			}
		} while (chon >= 8);
	}

}
