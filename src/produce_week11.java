import java.util.Arrays;
import java.util.Scanner;

public class produce_week11 {
    public static void main(String []args){
        System.out.println(Integer.MIN_VALUE/4);
       int n = 100;
       int []Ais = new int[101];
       int []Bis = new int[101];
       for (int i = 1;i<=100;i++){
           Ais[i] = (int)(100*Math.random());
           Bis[i] = (int)(100*Math.random());
           if (Ais[i]>=Bis[i]){
               int temp =  Ais[i];
               Ais[i] = Bis[i];
               Bis[i] = temp;
           }
       }
        System.out.println(100);
        for (int i = 1;i<=100;i++){
            System.out.println(Ais[i] + " " + Bis[i]);
        }
        
    }
}
