import java.util.Scanner;

public class simuliation_cs202_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 4;
        int m = 3;
        int a = 0;
        int q = 11;
        while (n != 0) {
            a = a << 1;
            if (q /8 >= 1){a += 1;}
            q = (q - q/8 )<< 1;
            
            if (a >= 0) {
                a = a - m;
            } else {
                a = a + m;
            }
            
            if (a >= 0){
                q +=1;
            }
            n = n-1;
        }
        while (a <= 0){
            a = a+m;
        }
        System.out.println(q);
        System.out.println(a);
        
    }
}
