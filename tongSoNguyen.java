import java.util.Scanner;
public class tongSoNguyen {
    public static void main(String[] args) {
        System.out.print("Nhập số nguyên cần tính tổng: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 0;
        for(int i = 1; i <= n; i++){
            s += i;
        }
        System.out.print("Tổng các chữ số tư nhiên từ 1 đến " +n + " là: " +s);
    }
}
