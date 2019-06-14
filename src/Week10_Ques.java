//import java.awt.*;
//import java.io.*;
//import java.util.*;
//
//public class Week10_Ques {
//
//    static class InputReader {
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//    }
//
//    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        int u = 121;
//        slove(in, out);
//        out.close();
//    }
//
//    static void slove(InputReader in, PrintWriter out) {
//        int d = in.nextInt();
//        int n = in.nextInt();
//        if (1 == n) {
//            int[] points = new int[d + 1];
//            for (int i = 1; i <= d; i++) {
//                points[i] = in.nextInt();
//            }
//            int begin = 0;
//            int end = 0;
//            int min = Integer.MAX_VALUE / 2;
//            Arrays.sort(points);
//            for (int i = 1; i < d; i++) {
//                int next_min = countDistanceOne(points[i], points[i + 1]);
//                if (min >= next_min) {
//                    min = next_min;
//                    begin = points[i];
//                    end = points[i + 1];
//                }
//            }
//            out.println(begin < end ? begin : end);
//            out.println(begin < end ? end : begin);
//        } else if (2 == n) {
//            point[] points = new point[d];
//            for (int i = 1; i <= d; i++) {
//                points[i - 1] = new point(in.nextLong(), in.nextLong());
//            }
//            Arrays.sort(points, new comparator_x_two());//x坐标,小到大排列
////            for (int i = 1; i <= d; i++) {
////                System.out.println(points[i - 1].x + " " + points[i - 1].y);
////            }
//            long[] prints = DoubleDemison(points, 0, d - 1);
//            out.println(prints[0] + " " + prints[1] + " " + prints[2]);
//            if (points[(int) prints[1]].x < points[(int) prints[2]].x) {
//                out.println(points[(int) prints[1]].x + " " + points[(int) prints[1]].y);
//                out.println(points[(int) prints[2]].x + " " + points[(int) prints[2]].y);
//            } else if (points[(int) prints[1]].x > points[(int) prints[2]].x) {
//                out.println(points[(int) prints[2]].x + " " + points[(int) prints[2]].y);
//                out.println(points[(int) prints[1]].x + " " + points[(int) prints[1]].y);
//            } else {
//                if (points[(int) prints[1]].y < points[(int) prints[2]].y) {
//                    out.println(points[(int) prints[1]].x + " " + points[(int) prints[1]].y);
//                    out.println(points[(int) prints[2]].x + " " + points[(int) prints[2]].y);
//                } else {
//                    out.println(points[(int) prints[2]].x + " " + points[(int) prints[2]].y);
//                    out.println(points[(int) prints[1]].x + " " + points[(int) prints[1]].y);
//                }
//            }
//            //
//        }
//
//
//    }
//
//    public static long[] DoubleDemison(point[] points, int begin, int end) {
//        //返回值 long数组中 0:最短距离 1:第一个点序号,2:第二个点序号
//        if (begin > end){
//            int temp = end;
//            end = begin;
//            begin = temp;
//        }
//        System.out.println(begin + " " + end);
//        long[] willreturn = new long[3];
//        if (2 == end - begin) {
//            long tempLength_1 = countDistanceTwo(points[begin], points[begin + 1]);
//            long tempLength_2 = countDistanceTwo(points[begin], points[end]);
//            long tempLength_3 = countDistanceTwo(points[begin + 1], points[end]);
//            if (tempLength_1 < tempLength_2 && tempLength_1 < tempLength_3) {
//                willreturn[0] = tempLength_1;
//                willreturn[1] = begin;
//                willreturn[2] = begin + 1;
//            } else if (tempLength_2 < tempLength_3 && tempLength_2 < tempLength_1) {
//                willreturn[0] = tempLength_2;
//                willreturn[1] = begin;
//                willreturn[2] = end;
//            } else {
//                willreturn[0] = tempLength_3;
//                willreturn[1] = begin + 1;
//                willreturn[2] = end;
//            }
//            return willreturn;
//        }
//        else if (1 == end - begin) {
//            willreturn[0] = countDistanceTwo(points[begin], points[end]);
//            willreturn[1] = begin;
//            willreturn[2] = end;
//            return willreturn;
//        }
//        if (end == begin) {
//            long tempLength_1 = Long.MAX_VALUE;
//            long tempLength_2 = Long.MAX_VALUE;
//            if (end < points.length - 1) {
//                tempLength_1 = countDistanceTwo(points[end], points[end + 1]);
//            }
//            if (begin > 0) {
//                tempLength_2 = countDistanceTwo(points[begin - 1], points[begin]);
//            }
//            if (begin > 0 && end < points.length - 1) {
//                if (tempLength_1 < tempLength_2) {
//                    willreturn[0] = tempLength_1;
//                    willreturn[1] = end;
//                    willreturn[2] = end + 1;
//                } else {
//                    willreturn[0] = tempLength_2;
//                    willreturn[1] = begin - 1;
//                    willreturn[2] = begin;
//                }
//            } else if (begin > 0) {
//                willreturn[0] = tempLength_2;
//                willreturn[1] = begin-1;
//                willreturn[2] = begin;
//            }else {
//                willreturn[0] = tempLength_1;
//                willreturn[1] = end;
//                willreturn[2] = end + 1;
//            }
//            return willreturn;
//        }
//        else if (end - begin > 2) {
//            int middle = (end - begin) / 2 + begin;
//            long[] array1 = DoubleDemison(points, begin, middle);
//            System.out.println("array1 " + array1[0] + " " + array1[1] + " " + array1[2]);
//            long[] array2 = DoubleDemison(points, middle + 1, end);
//            System.out.println("array2 " + array2[0] + " " + array2[1] + " " + array2[2]);
//            willreturn = array1[0] < array2[0] ? array1 : array2;
//             System.out.println("willreturn_temp " + willreturn[0] + " " + willreturn[1] + " " + willreturn[2]);
//            double temp_Min = Math.sqrt(willreturn[0]);
//            //此处二分查找两边的边界,之后将其加入优先队列,按ypa
//
//            int tempBegin = begin;
//            int tempEnd = middle + 1;
//            int tempMiddle;
//            while (tempBegin < tempEnd) {
//                tempMiddle = (tempEnd - tempBegin) / 2 + tempBegin;
//                if (points[middle].x - points[tempMiddle].x > temp_Min) {
//                    tempBegin = tempMiddle + 1;
//                } else {
//                    tempEnd = tempMiddle;
//                }
//            }
//            //现在返回的是一个 第一个小于最短距离的值的位置- tempBegin && tempEnd 都可以
//            int store_left = tempBegin;
//
//            tempBegin = middle + 1;
//            tempEnd = end + 1;
//            while (tempBegin < tempEnd) {
//                tempMiddle = (tempEnd - tempBegin) / 2 + tempBegin;
//                if (points[tempMiddle].x - points[middle].x < temp_Min) {
//                    tempBegin = tempMiddle + 1;
//                } else {
//                    tempEnd = tempMiddle;
//                }
//            }int store_right = tempBegin - 1;
//            //返回tempBegin - 第一个大于willreturn[0]的值,需要-1
//
//            point[] points_y = new point[store_right - store_left + 1];
//            for (int i = 0; i <= store_right - store_left; i++) {
//                points_y[i] = points[store_left + i];
//            }
//            Arrays.sort(points_y, new comparator_y_two());
//            //现在区间左侧是 store_left,右侧是store_right
//            if (store_right - store_left >= 6) {
//                boolean flashInThere = false;
//                for (int i = 0; i + 6 <= store_right - store_left; i++) {
//                    for (int j = i + 1; j <= 6; j++) {
//                        long tempLength_2 = countDistanceTwo(points_y[i], points_y[i + j]);
//                        if (tempLength_2 < willreturn[0]) {
//                            flashInThere = true;
//                            willreturn[0] = tempLength_2;
//                            willreturn[1] = i;
//                            willreturn[2] = i + j;
//                        }
//                    }
//                }
//                //还剩6个
//                for (int i = store_right - 5 - store_left; i < store_right - store_left; i++) {
//                    for (int j = i + 1; j <= store_right - store_left; j++) {
//                        long tempLength_3 = countDistanceTwo(points_y[i], points_y[j]);
//                        if (tempLength_3 < willreturn[0]) {
//                            flashInThere = true;
//                            willreturn[0] = tempLength_3;
//                            willreturn[1] = i;
//                            willreturn[2] = j;
//                        }
//                    }
//                }
//                //应该在此处用O(n)扫一遍
//                if (flashInThere) {
//                    a3:
//                    for (int i = store_left; i <= store_right; i++) {
//                        if (points[i].x == points_y[(int) willreturn[1]].x && points[i].y == points_y[(int) willreturn[1]].y) {
//                            willreturn[1] = i;
//                            break a3;
//                        }
//                    }
//                    a4:
//                    for (int i = store_left; i <= store_right; i++) {
//                        if (points[i].x == points_y[(int) willreturn[2]].x && points[i].y == points_y[(int) willreturn[2]].y) {
//                            willreturn[2] = i;
//                            break a4;
//                        }
//                    }
//                }
//                return willreturn;
//            } else {
//                boolean flashInhere = false;
//                for (int i = 0; i < store_right - store_left; i++) {
//                    for (int j = i + 1; j <= store_right - store_left; j++) {
//                        long tempLength_4 = countDistanceTwo(points_y[i], points_y[j]);
//                        if (tempLength_4 < willreturn[0]) {
//                            flashInhere = true;
//                            willreturn[0] = tempLength_4;
//                            willreturn[1] = i;
//                            willreturn[2] = j;
//                        }
//                    }
//                }
//                if (flashInhere) {
//                    a1:
//                    for (int i = store_left; i <= store_right; i++) {
//                        if (points[i].x == points_y[(int) willreturn[1]].x
//                                && points[i].y == points_y[(int) willreturn[1]].y) {
//                            willreturn[1] = i;
//                            break a1;
//                        }
//                    }
//                    a2:
//                    for (int i = store_left; i <= store_right; i++) {
//                        if (points[i].x == points_y[(int) willreturn[2]].x &&
//                                points[i].y == points_y[(int) willreturn[2]].y) {
//                            willreturn[2] = i;
//                            break a2;
//                        }
//                    }
//                }
//            }
//            return willreturn;
//        }
//        return willreturn;
//    }
//
//    public static class point {
//        long x;
//        long y;
//
//        point(long x, long y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    static class comparator_x_two implements Comparator<point> {
//        @Override
//        public int compare(point p1, point p2) {
//            if (p1.x > p2.x) {
//                return 1;
//            } else if (p1.x < p2.x) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }//小 → 大
//
//    static class comparator_y_two implements Comparator<point> {
//        @Override
//        public int compare(point p1, point p2) {
//            if (p1.y > p2.y) {
//                return 1;
//            } else if (p1.y < p2.y) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }//小 → 大
//
//    public static int countDistanceOne(int x1, int x2) {
//        return (x1 > x2 ? x1 - x2 : x2 - x1);
//    }
//
//    public static long countDistanceTwo(point p1, point p2) {
//        long diffx = (p1.x > p2.x ? p1.x - p2.x : p2.x - p1.x);
//        long diffy = (p1.y > p2.y ? p1.y - p2.y : p2.y - p1.y);
//        return diffx * diffx + diffy * diffy;
//    }
//
//    public static long countDistanceThree(long x1, long y1, long z1, long x2, long y2, long z2) {
//        long diffx = (x1 > x2 ? x1 - x2 : x2 - x1);
//        long diffy = (y1 > y2 ? y1 - y2 : y2 - y1);
//        long diffz = (z1 > z2 ? z1 - z2 : z2 - z1);
//        return diffx * diffx + diffy * diffy + diffz * diffz;
//    }
//}