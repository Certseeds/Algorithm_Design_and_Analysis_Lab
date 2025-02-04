import java.io.*;
import java.util.*;

public class Week9_Que {
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
    }
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int u = 121;
        slove(in, out);
        out.close();
    }
    
    static void slove(InputReader in, PrintWriter out) {
        System.out.println(300);
        for (int i = 1; i <= 300; i++) {
            int randomNumber = (int) (1000 * Math.random());
            System.out.println(randomNumber);
            for (int j = 0; j < randomNumber; j++) {
                System.out.println((int) (Math.min(300, randomNumber) * Math.random()));
            }
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[] strips = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                strips[j] = in.nextInt();
            }
            out.println(judgeStrip(strips, 1, n) ? "Yes" : "No");
        }
    }
    
    public static boolean judgeStrip(int[] array, int begin, int end) {
        if (begin == end) {
            return true;
        } else if (end - begin == 1) {
            return (array[begin] != array[end]);
        } else if (begin >= end) {
            return true;
        }
        
        HashMap<Integer, Integer> use = new HashMap<>();
        for (int i = begin; i <= end; i++) {
            if (!use.containsKey(array[i])) {
                use.put(array[i], 1);
            } else {
                use.put(array[i], use.get(array[i]) + 1);
            }
        }
        int count = 0;
        PriorityQueue<Integer> use2 = new PriorityQueue<>();//小根堆
        for (int i = begin; i <= end; i++) {
            if (use.get(array[i]) != null && use.get(array[i]) == 1) {
                use2.add(i);
                count++;
            }
        }
        if (count == 0) {
            return false;
        } else if (count == end - begin + 1) {
            return true;
        } else {
            int tempBegin = begin;
            int tempend = use2.poll() - 1;
            for (int i = 0; i < count; i++) {
                boolean temp2 = judgeStrip(array, tempBegin, tempend);
                if (!temp2) {
                    return false;
                }
                tempBegin = tempend + 2;
                if (!use2.isEmpty()) {
                    tempend = use2.poll() - 1;
                }
            }
            boolean temp3 = judgeStrip(array, tempBegin, end);
            if (!temp3) {
                return false;
            }
        }
        return true;
    }
    
}