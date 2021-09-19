public class sdDiem {
    public static void main(String[] args) {
        toaDoDiem A = new toaDoDiem();
        A.nhapToaDo();
        A.hienThi();
        double kc = A.khoangCach();
        System.out.print("Khoảng cách từ điểm A đến gốc tọa độ (0;0) là : " + kc);

    }
}
