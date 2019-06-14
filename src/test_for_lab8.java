import java.util.Scanner;

public class test_for_lab8 {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        long []array1 = new long[length + 1];
        long []array2 = new long[length + 1];
    
        for (int i = 1;i<= length;i++){
            array1[i] = input.nextLong();
        }
        System.out.println("OK");
        for (int i = 1;i<= length;i++){
            array2[i] = input.nextLong();
        }
        System.out.println("OK");
        for (int i = 1;i<= length;i++){
            if (array1[i] != array2[i]){
                System.out.println(i + " " + array1[i] + " " + array2[i]);
            }
        }
        System.out.println("OK");
    }
}
