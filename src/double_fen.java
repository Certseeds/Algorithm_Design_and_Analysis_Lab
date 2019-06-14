public class double_fen {
    public static void main(String[] args) {
            int random = (int) (2000 * Math.random());
            boolean[] judge = new boolean[4];
            for (int i = 0; i <=3; i++) {
                if (i <= 1) {
                    judge[i] = true;
                } else {
                    judge[i] = false;
                }
            }
           // System.out.println(random);
            int maxValue = 4;
            int minValue = 0;
            int middleValue = 0;
            
            while (minValue < maxValue) {
                middleValue = minValue + (maxValue - minValue) / 2;
                if (judge[middleValue]) {
                    minValue = middleValue + 1;
                } else {
                    maxValue = middleValue;
                }
                //System.out.println(minValue + " "+middleValue+" " +maxValue);
            }
            System.out.println(minValue-1);
           
    }
}
