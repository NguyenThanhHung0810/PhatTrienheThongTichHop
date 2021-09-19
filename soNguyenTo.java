import java.util.Scanner;

public class soNguyenTo {
    public static void main(String[] args) {
        int n;
        int dem = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Nhập n = ");
        n = s.nextInt();
        for(int i=1; i<=n; i++) {
            if(n%i==0){
                dem ++;
            }
        }
        if(dem == 2){
            System.out.println(n + " là số nguyên tố");
        }
        else{
            System.out.println(n + " không phải là số nguyên tố");
        }
    }
}
