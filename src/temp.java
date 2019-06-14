import java.io.*;
import java.util.*;

public class temp {
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
        
        int n = in.nextInt();
        int p = in.nextInt();
        int []array = new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = in.nextInt() % p;
        }
        
        long[][] matrix = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = (array[i] * array[j]) % p;
            }
        }
        int[] output = new int[p];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                output[(int)matrix[i][j]] ++;
            }
        }
        for (int i = 0;i < p;i++){
            out.println(output[i]);
        }
    }
    
}