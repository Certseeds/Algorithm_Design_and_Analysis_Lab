import java.util.Comparator;
        import java.util.PriorityQueue;
        import java.util.Queue;
        import java.util.StringTokenizer;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.PrintWriter;

public class Lab4_Que {
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        
        public InputReader(InputStream stream) {
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
        Comparator<edge> comparatorOfEdges = new Comparator<edge>() {
            //@Override
            public int compare(edge o1, edge o2) {
                int o1length = o1.length;
                int o2length = o2.length;
                if (o1length > o2length) {
                    return 1;
                } else if (o1length < o2length) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        
        boolean[] isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            isVisited[i] = false;
        }
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                matrix[i][j] = in.nextInt();
                matrix[j][i] = matrix[i][j];
            }
        }
        long  lengthOfMinTree = 0;
        int beginKey = 0;
        isVisited[0] = true;
        edge NetTemp = new edge(1,matrix[0][1]);
        Queue<edge> edges = new PriorityQueue<>(comparatorOfEdges);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (!isVisited[j] && j != beginKey){
                    edges.add(new edge(j,matrix[beginKey][j]));
                }
            }
            while (!edges.isEmpty() && isVisited[edges.peek().end]){
                edges.poll();
            }
            if (!edges.isEmpty()){
                NetTemp = edges.poll();
            }
            beginKey = NetTemp.end;
            isVisited[beginKey] = true;
            lengthOfMinTree += NetTemp.length;
        }
        out.println(lengthOfMinTree);
    }
    
    static class edge {
        int end;
        int length;
        edge(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }
}
