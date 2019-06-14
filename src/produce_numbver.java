public class produce_numbver {
    public static void main(String []args){
        final int big = 100000000;
        int n = 10000;
        int p = 7681;
        System.out.println(n + " " + p);
        for (int i = 0;i < n;i++){
            System.out.println((int)(big * Math.random()));
        }
    }
}
