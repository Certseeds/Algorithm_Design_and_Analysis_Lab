
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Week8_Ques {
    
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
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            out.println(getBuses(n, x, y));
        }
    }
    
    public static long getBuses(int n, int x, int y) {
        long count = 0;
        if (x == 0 && y == 0) {
            return n;
        }
        if (2 * n > y) {
            if (y % 2 == 1) {
                count = count + y / 2;
                // 先剩一个小货物
                n = n - y / 2;
                y = 1;
                if (n > x) {
                    count = count + x;
                    n = n - x;
                    //不需要加1,因为n还大于0
                    return count + n;
                } else if (n == x) {
                    count = count + x;
                    x = 0;
                    return count + 1;
                } else if (n < x) {
                    if (n % 2 == 0) {
                        if (x % 2 == 0) {
                            count = count + n;
                            x = x - n;
                            return count + 1 + x / 2;
                        } else {
                            count = count + n;
                            x = x - n + 1;
                            return count + x / 2;
                        }
                    }
                    if (n % 2 == 1) {
                        if (x % 2 == 0){
                            count = count +n;
                            x = x - n+1;
                            return count + x/2;
                        }else {
                        count = count + n;
                        x = x - n;
                        n = 0;
                        return count + 1 + x / 2 + (x %2 ==0?0:1);
                        }
                    }
                }
            } else {
                count = count + y / 2;
                n = n - y / 2;
                if (n >= x) {
                    return count + n;
                } else if (n < x) {
                    count = count + n;
                    x = x - n;
                    n = 0;
                    return count + x / 2 + (x % 2 == 0 ? 0 : 1);
                }
            }
        } else if (2 * n == y) {
            count = count + n;
            n = 0;
            y = 0;
            return count + x / 2 + (x % 2 == 0 ? 0 : 1);
        } else if (2 * n < y) {
            if ((y-2*n) % 3 == 2 && x % 2 == 1) {
                count = count + n + 2;
                x = x - 1;
                y = y -2*n;
                return count + x / 2 + y / 3;
            }
            else if((y - 2 * n)%3 == 1 && x%2 == 1){
                count = count +n;
                x =  x -1;
                y = y - 2*n +2;
                return count + x/2 + y/3;
            }
            count = count + n;
            y = y - n * 2;
            return count + x / 2 + (x % 2 == 0 ? 0 : 1) + y / 3 + (y % 3 == 0 ? 0 : 1);
        }
        return 0;
    }

//    public static int getBuss(int n, int x, int y) {
//        int count = 0;
//        int x_excess = x % 2;
//        int y_excess = y % 3;
//        if (x_excess == 1 && n >= 1) {
//            count += 1;
//            n = n - 1;
//            x = x - 1;
//        }
//        if (y_excess != 0 && n >= 1) {
//            count += 1;
//            n = n - 1;
//            y = y - y_excess;
//            y_excess = 0;
//        }
//        if (n == 0) {
//            count = count + x / 2;
//            switch (y_excess) {
//                case 0: {
//                    count += y / 3;
//                    break;
//                }
//                default: {
//                    count += (y + 3 - y_excess) / 3;
//                }
//            }
//            System.out.println("case1");
//            return count;
//            //解决了n = 1,至少有一个求余!=0的情况
//            //解决了n= 2, 求余全都!= 0的情况
//        }
//        //此处 n 至少为1,x 为2的倍数,y为3的倍数(1,0,0亦可)
//
//        int first_pair = Math.min(n / 3, y / 6);
//        count += first_pair * 3;
//        n = n - first_pair * 3;
//        y = y - first_pair * 6;
//        if (n == 0 && y == 0) {
//            System.out.println("case2");
//            return count + x / 2;
//        } else if (n == 0) {
//            System.out.println("case3");
//            return count + x / 2 + y / 3;
//        }
//        count += y / 3;
//        y = 0;
//        //此时,n != 0,x为2的倍数,y = 0
//        int second_pair = Math.min(n / 2, x / 2);
//        count = count + second_pair * 2;
//        n = n - second_pair * 2;
//        x = x - second_pair * 2;
//        if (n == 0 && x == 0) {
//            System.out.println("case4");
//            return count;
//        } else if (n == 0 && x != 0) {
//            System.out.println("case5");
//            return count + x / 2;
//        } else if (n == 1 && x != 0) {
//            System.out.println("case6");
//            return count + 1 + x / 2;
//        } else if (n != 0 && x == 0) {
//            System.out.println("case7");
//            return count + n;
//        }
//
//
//        return count;
//    }
    
    
}
