import java.io.*;
import java.util.*;

public class RandomNumber {
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
    public static int[][] RootArray(int root, int p) {
        int[][] willreturn = new int[2][p];
        int n = root;
        for (int i = 1; i <= p - 1; i++) {
            willreturn[0][n % p] = i;
            willreturn[1][i] = n % p;
            n = ((n % p) * root) % p;
        }
        return willreturn;
    }
    static void slove(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int p = in.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = (in.nextInt() % p);
    }
        int rootNumber = getRoot(p);
        int[][] rootArray = RootArray(rootNumber, p);
        
        int[] rootArray1 = rootArray[0];
        int[] rootArray2 = rootArray[1];
        int[] numberArray = new int[p];
        for (int i = 0; i < p; i++) {
            numberArray[i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (array[i] % p != 0) {
                numberArray[rootArray1[array[i]]]++;
                //此处如果
            }
        }
        int length = 1;
        int cifang = 0;
        while (length < p) {
            length *= 2;
            cifang += 1;
        }
        length *= 2;
        cifang += 1;
       // System.out.println(length + "  " + cifang);
        complex[] com1 = new complex[length];
        complex[] com2 = new complex[length];
        for (int i = 0; i < length; i++) {
            com1[i] = new complex(0, 0);
            com2[i] = new complex(0, 0);
        }
        for (int i = 0; i < p; i++) {
            com1[i].real = numberArray[i];
            com2[i].real = numberArray[i];
        }
        FFT(com1, 0, length - 1, 1);
        FFT(com2, 0, length - 1, 1);
        for (int i = 0; i <length; i++) {
            com1[i] = com1[i].multi(com2[i]);
        }
        FFT(com1, 0, length - 1, -1);
        int[] result = new int[length];
        for (int i = 0; i <length; i++) {
            result[i] = (int) (com1[i].real /length +0.5);
        }
       //System.out.println(Arrays.toString(result));
        int[] Willoutput = new int[p];
        for (int i = 0; i < length; i++) {
            Willoutput[rootArray2[i % (p - 1)]] += result[i];
        }
        Willoutput[1] = Willoutput[0];
        Willoutput[0] = n * n;
        for (int i = 1; i < p; i++) {
            Willoutput[0] -= Willoutput[i];
        }
        for (int i = 0; i < p; i++) {
            out.println(Willoutput[i]);
        }
    }
    
    public static void FFT(complex[] array, int begin, int end, int state) {
        if (0 == end - begin) {
            return;
        }else if (1 == end-begin){
            complex temp1 = complex.copy(array[begin]);
            complex temp2 = complex.copy(array[end]);
            complex temp3 = new complex(Math.cos(0), state * Math.sin(0));
            array[begin] = temp1.add(temp3.multi(temp2));
            array[end] = temp1.minus(temp3.multi(temp2));
            return;
        }else {
            int middle = (end - begin) / 2 + begin;
            complex[] a1 = new complex[end - begin + 1];
            for (int i = 0; i <= middle-begin; i++) {
                a1[i] = complex.copy(array[begin + 2 * i]);
                a1[i + (middle - begin)+1] = complex.copy(array[begin + 2 * i + 1]);
            }
            FFT(a1, 0, middle-begin, state);
            FFT(a1, middle -begin+1, end-begin, state);
            for (int i = 0; i <= middle-begin; i++) {
                final double pais = Math.PI * 2 * i / (end - begin + 1);
                complex temp = new complex(Math.cos(pais), state * Math.sin(pais));
                array[begin + i] = a1[i].add(temp.multi(a1[i + middle-begin+1]));
                array[middle + i+1] = a1[i].minus(temp.multi(a1[i + middle-begin+1]));
            }
        }
    }
    public static class complex {
        double real = 0.0;
        double image = 0.0;
        
        complex(double real, double image) {
            this.real = real;
            this.image = image;
        }
        
        public complex add(complex c1) {
            return new complex(this.real + c1.real, this.image + c1.image);
        }
        
        public complex minus(complex c1) {
            return new complex(this.real - c1.real, this.image - c1.image);
        }
        
        public complex multi(complex c1) {
            return new complex(this.real * c1.real - this.image * c1.image, this.real * c1.image + this.image * c1.real);
        }
        
        public static complex copy(complex c) {
            return new complex(c.real, c.image);
        }
    }
    
    public static int getRoot(int p) {
        int[] primes = getPrime(p - 1);
        int lengthOfPrime = primes.length;
        // System.out.println(Arrays.toString(primes));
        int minRootNumber = 1;
        a2:
        for (int i = 2; i <= p - 1; i++) {
            boolean isRootNumber = true;
            a1:
            for (int j = 1; j <= lengthOfPrime - 1; j++) {
                if (judgeMod1(i, (p - 1) / primes[j], p) == 1) {
                    isRootNumber = false;
                    break a1;
                }
            }
            if (isRootNumber) {
                minRootNumber = i;
                break a2;
            }
        }
        return minRootNumber;
    }
    

    
    public static long judgeMod1(int a, int mi, int p) {
        if (mi == 1) {
            return a % p;
        } else if (mi == 2) {
            return ((a % p) * (a % p)) % p;
        } else {
            int begin = 1;
            int end = mi;
            int middle = (mi - 1) / 2 + 1;
            if (middle == mi - middle) {
                long leftOne = judgeMod1(a, middle, p);
                return (leftOne * leftOne) % p;
            } else if (middle >= mi - middle) {
                long rightOne = judgeMod1(a, mi - middle, p);
                long leftOne = (rightOne * judgeMod1(a, middle * 2 - mi, p)) % p;
                return (leftOne * rightOne) % p;
            } else {
                long leftOne = judgeMod1(a, middle, p);
                long rightOne = (leftOne * judgeMod1(a, mi - 2 * middle, p)) % p;
                return (leftOne * rightOne) % p;
            }
        }
    }
    
    public static int[] getPrime(int x) {
        ArrayList<Integer> willreturn = new ArrayList<Integer>();
        while (x > 1) {
            a1:
            for (int i = 2; i <= x; i++) {
                if (x % i == 0) {
                    willreturn.add(i);
                    x = x / i;
                    break a1;
                }
            }
        }
        int[] primes = new int[willreturn.size() + 1];
        for (int i = 1; i < primes.length; i++) {
            primes[i] = willreturn.get(i - 1);
        }
        return primes;
    }
}