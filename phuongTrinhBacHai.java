import java.util.Scanner;
public class phuongTrinhBacHai {
     public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            System.out.print("a = "); int a = s.nextInt();
            System.out.print("b = "); int b = s.nextInt();
            System.out.print("c = "); int c = s.nextInt();

            if(a == 0){
                if(b == 0){
                    if(c == 0){
                        System.out.println("Phương trình vô sô nghiệm ");
                    } 
                    else{
                        System.out.println("Phương trình vô nghiệm ");
                    }
                }
                else{
                    float x = (float)(-b)/c;
                    System.out.printf("Nghiệm của phương trình là: x=%.1f ",x);
                }
            }
            else{
                float delta = b*b-4*a*c;
                if(delta<0){
                    System.out.println("Phương trình vô nghiệm ");
                }
                else if(delta==0){
                    System.out.printf("Phương trình có nghiệm kép là x=%.1f",-b/(2*a));
                }
                else{
                    float x1 = (float)(((-b)+Math.sqrt(delta))/2*a);
                    float x2 = (float)(((-b)-Math.sqrt(delta))/2*a);
                    System.out.println("Phương trình có 2 nghiệm:");
                    System.out.printf("x1 = %.1f", x1);
                    System.out.println();
                    System.out.printf("x2 = %.1f", x2);
                }
            }
        }
     }
