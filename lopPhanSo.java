import java.util.Scanner;

//phương thức khởi tạo phân số
public class lopPhanSo {
    private int tuSo;
    private int mauSo ;

        // phương thức khởi tạo không tham số
        public lopPhanSo() {
            tuSo = 0;
            mauSo = 1;
        }
    
        // phương thức khởi tạo có đối số
        public lopPhanSo(int tuSo, int mauSo) {
            if (mauSo == 0) {
                System.out.println("Mau so khong duoc bang 0");
                tuSo = 0;
                mauSo = 1;
            } else {
                this.tuSo = tuSo;
                this.mauSo = mauSo;
            }
        }
    
        // phương thức nhập vào tử số và mẫu số
        public void nhapPhanSo(Scanner sc) {
            int ts;
            int ms;
            do {
                System.out.print("\tMời bạn nhập vào tử số : ");
                ts = sc.nextInt();
                System.out.print("\tMời bạn nhập vào mẫu số : ");
                ms = sc.nextInt();
    
                if (ms == 0) {
                    System.out.println("Xin lỗi! Mời bạn nhập lại thông tin cho phân số.");
                }
            } while (ms == 0);
            
        }

        //phương thức gán phân số
        public void ganPhanSo(int ts, int ms){
            tuSo = ts;
            mauSo = ms;
        }
    
        // Phương thức hiển thị phân số
        public void hienThiPhanSo() {
            if (tuSo * mauSo < 0) {
                System.out.println("-" + Math.abs(tuSo) + "/" + Math.abs(mauSo));
            } else {
                System.out.println(Math.abs(tuSo) + "/" + Math.abs(mauSo));
            }
        }

        // Phương thức nghịch đảo phân số
        public void inverse() {
            int tg = tuSo;
            tuSo = mauSo;
            mauSo = tg;
        }
    
        // Ham cong 2 phan so
        public lopPhanSo congPS(lopPhanSo ps2) {
            int ts = tuSo * ps2.mauSo + ps2.tuSo * mauSo;
            int ms = mauSo * ps2.mauSo;
            return new lopPhanSo(ts, ms);
        }
    
        // Ham tru 2 phan so
        public lopPhanSo truPS(lopPhanSo ps2) {
            int ts = tuSo * ps2.mauSo - ps2.tuSo * mauSo;
            int ms = mauSo * ps2.mauSo;
            return new lopPhanSo(ts, ms);
        }
    
        // Ham nhan 2 phan so
        public lopPhanSo nhanPS(lopPhanSo ps2) {
            int ts = tuSo * ps2.tuSo;
            int ms = mauSo * ps2.mauSo;
            return new lopPhanSo(ts, ms);
        }
    
        
    
        // Chia 2 phan so
        public lopPhanSo chiaPS(lopPhanSo ps2) {
            // Nghich dao ps2
            int tg = ps2.tuSo;
            ps2.tuSo = ps2.mauSo;
            ps2.mauSo = tg;
    
            // Nhan this vs ps2 (da nghich dao)
            int ts = tuSo * ps2.tuSo;
            int ms = mauSo * ps2.mauSo;
            return new lopPhanSo(ts, ms);
        }
    
        // Ham toi gian phan so
        public void reduce() {
            // Tim uscln
            int a = tuSo;
            int b = mauSo;
            int r = a % b;
            while (r != 0) {
                a = b;
                b = r;
                r = a % b;
            }
    
            // Toi gian phan so
            tuSo /= b;
            mauSo /= b;
        }
}
