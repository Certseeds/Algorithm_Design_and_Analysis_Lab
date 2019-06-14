import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
/*
Accept Successfully
* */

public class Lab5_Qus {
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
        int[] begin = new int[n + 1];
        int[] end = new int[n + 1];
        pair[] friends = new pair[n + 1];
        int beginTime = Integer.MAX_VALUE / 4;
        int endTime = 0;
        int minTime = Integer.MAX_VALUE / 4;
        for (int i = 1; i <= n; i++) {
            begin[i] = in.nextInt();
            beginTime = Math.min(begin[i], beginTime);
            end[i] = in.nextInt();
            endTime = Math.max(end[i], endTime);
            minTime = Math.min(minTime, end[i] - begin[i]);
            friends[i] = new pair(begin[i], end[i]);
        }
        minTime = Math.min(minTime, (endTime - beginTime + 1) / n);
        //System.out.println(minTime);
        int maxValue = minTime + 1;
        int minValue = 0;
        int middleValue;
        while (minValue < maxValue) {
            middleValue = minValue + (maxValue - minValue) / 2;
            boolean peopleNumebr = getNumebr(friends, middleValue, beginTime, endTime);
            if (peopleNumebr) {
                minValue = middleValue + 1;
            } else {
                maxValue = middleValue;
            }
            //out.println(minValue + " " + middleValue + " " + maxValue);
        }
        out.println(minValue - 1);
        
    }
    
    public static boolean getNumebr(pair[] friends, int time, int beginTime, int endTime) {
        if (time == 0) {
            return true;
        }
        boolean[] used = new boolean[endTime - beginTime + 1];
        Comparator<pair> comparatorOfFriends = new Comparator<pair>() {
            //@Override
            public int compare(pair o1, pair o2) {
                
                int o1length = o1.end;
                int o2length = o2.end;
                if (o1length > o2length) {
                    return 1;
                } else if (o1length < o2length) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Queue<pair> friendsQueue = new PriorityQueue<pair>(comparatorOfFriends);
        for (int i = 1; i < friends.length; i++) {
            friendsQueue.add(friends[i]);
        }
        while (!friendsQueue.isEmpty()) {
            pair tempPair = friendsQueue.poll();
            int tempBegin = tempPair.begin;
            int tempEnd = tempPair.end;
            int tempCount = 0;
            a1:
            for (int j = tempBegin - beginTime; j <= tempEnd - beginTime; j++) {
                //System.out.println(Arrays.toString(used));
                if (tempCount == time) {
                    break a1;
                }
                if (!used[j]) {
                    used[j] = true;
                    tempCount++;
                }
                //System.out.println(Arrays.toString(used));
            }
            if (tempCount != time) {
                //System.out.println(time + " false ");
                return false;
            }
        } //System.out.println(time + " true");
        return true;
    }
    
    static class pair {
        int begin = 0;
        int end = 0;
        
        pair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}