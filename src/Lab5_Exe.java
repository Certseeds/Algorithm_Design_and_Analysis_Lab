import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lab5_Exe {
    static class InputReader {
        private StreamTokenizer tokenizer;
        
        public InputReader(InputStream stream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = new StreamTokenizer(reader);
        }
        
        private double next() throws IOException {
            if (tokenizer != null) {
                tokenizer.nextToken();
            }
            return tokenizer.nval;
        }
        
        private int nextInt() throws IOException {
            return (int) next();
        }
        
        private double nextDouble() throws IOException {
            return next();
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

//        int t = in.nextInt();
//        for (int i = 1; i <= t; i++) {
//            int n = in.nextInt();
//            int[] beginTime = new int[n];
//            int[] endTime = new int[n];
//            for (int k = 0; k < n; k++) {
//                beginTime[k] = in.nextInt();
//                endTime[k] = in.nextInt();
//            }
//            out.println(GetNumber(beginTime, endTime));
//
//        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            Pair[] times = new Pair[n];
            for (int k = 0; k < n; k++) {
                times[k] = new Pair(in.nextInt(), in.nextInt());
            }
            out.println(GetNumber(times));
            
        }
        out.close();
    }
    
    static class Pair {
        int begin = 0;
        int end = 0;
        Pair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    public static int GetNumber(Pair[] times) {
        Comparator<Pair> comparatorOfStudents = new Comparator<Pair>() {
            //@Override
            public int compare(Pair o1, Pair o2) {
                int o1length = o1.begin;
                int o2length = o2.begin;
                if (o1length > o2length) {
                    return 1;
                } else if (o1length < o2length) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Queue<Pair> timesQueue = new PriorityQueue<Pair>(comparatorOfStudents);
        for (int j = 0; j < times.length; j++) {
            timesQueue.add(times[j]);
        }
        int count = 0;
        int endTime = 0;
        while (!timesQueue.isEmpty()) {
            Pair temp = timesQueue.poll();
            if (temp.begin >= endTime) {
                count++;
                endTime = temp.end;
            }
        }
        return count;
    }
}
