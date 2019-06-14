import java.util.Scanner;

public class Week_10_Ques_produce_data {
    public static void main(String[] args) {
        //int RandomNumebr = 100 + (int) (9900 * Math.random());
        int RandomNumebr = 10000;
        int randomDemesion = (Math.random() > 0.5 ? 2 : 2);
        System.out.println(RandomNumebr);
        System.out.println(randomDemesion);
        int[][] points = new int[RandomNumebr][randomDemesion];
        if (2 == randomDemesion) {
            for (int i = 0; i < RandomNumebr; i++) {
                points[i][0] = (int) (100000000 * Math.random());
                points[i][1] = (int) (100000000 * Math.random());
                System.out.println(points[i][0] + " " + points[i][1]);
            }
            
        } else {
            for (int i = 0; i < RandomNumebr; i++) {
                points[i][0] = (int) (100000000 * Math.random());
                points[i][1] = (int) (100000000 * Math.random());
                points[i][2] = (int) (100000000 * Math.random());
                System.out.println(points[i][0] + " " + points[i][1] + " " + points[i][2]);
            }
        }
        
    }
}
