import java.util.Scanner;

public class testForNewton {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        double number = input.nextDouble();
        int jingdu = input.nextInt();
        double jutijingdu = 1;
        double begin = 1;
        for (int i = 1;i <=jingdu;i++){
            jutijingdu /= 10;
        }
        while (Math.abs(Math.pow(begin,2) - number) >=jutijingdu){
            begin = (begin + number/begin)/2;
            System.out.println(begin);
        }
        System.out.println(begin);
    }
}
