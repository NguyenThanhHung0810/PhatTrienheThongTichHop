import java.util.Scanner;
//phương thức khởi tạo
public class toaDoDiem {
    private int x;
    private int y;

    //phương thức nhập tọa độ một điểm
    public void nhapToaDo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tọa độ x = ");
        x = sc.nextInt();
        System.out.print("Nhập tọa độ y = ");
        y = sc.nextInt();
    }

    //phương thức hiển thị tọa độ một điểm
    public void hienThi(){
        System.out.print("Tọa độ điểm vừa nhập là : ");
        System.out.println("(" + x + "," + y + ")");
    }

    //phương thức dời tọa độ một điểm
    public void doiDiem(int dx, int dy){
        x = x + dx;
        y = y + dy;
    }

    //phương thức lấy giá trị tọa độ một điểm
    public int giaTriX(){
        return x;
    }
    public int giaTriY(){
        return y ;
    }

    //phương thức gán giá trị cho một điểm
    public void ganX(int x1){
       x = x1;
    }
    public void ganY(int y1){
        y = y1;
    }

    //phương thức tính khoảng cách một điểm đến gốc tọa độ
    public double khoangCach(){
        return Math.sqrt(x*x+y*y);
    }
}
