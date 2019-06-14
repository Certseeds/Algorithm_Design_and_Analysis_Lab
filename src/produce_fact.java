import java.util.Scanner;

public class produce_fact {
    public static void main(String[] args){
        Scanner input = new Scanner (System.in);
        int number = input.nextInt();
        int temp = 2;
        while (number != 1){
            if (number %temp != 0){
                temp++;
            }
            else {
                number = number / temp;
                System.out.println(temp);
                temp = 2;
            }
        }
    }
}
