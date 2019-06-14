//import java.util.Comparator;
//
//public class Week10_random_test {
//    public static void main(String[] args) {
//
//        int RandomNumebr = 100 + (int) (9900 * Math.random());
//        int randomDemesion = (Math.random() > 0.5 ? 2 : 2);
//        long[][] points = new long[RandomNumebr][randomDemesion];
//        if (2 == randomDemesion) {
//            for (int i = 0; i < RandomNumebr; i++) {
//                points[i][0] = (int) (100000000 * Math.random());
//                points[i][1] = (int) (100000000 * Math.random());
//            }
//
//        }
//        else {
//            for (int i = 0; i < RandomNumebr; i++) {
//                points[i][0] = (int) (100000000 * Math.random());
//                points[i][1] = (int) (100000000 * Math.random());
//                points[i][2] = (int) (100000000 * Math.random());
//            }
//        }
//        //part 2 brute force
//        int n = RandomNumebr;
//        int demison = randomDemesion;
//        long minvalue = Long.MAX_VALUE;
//        int begin = 1;
//        int end = 1;
//        switch (demison) {
//            case 2: {
//                for (int i = 0; i < n - 1; i++) {
//                    for (int j = i + 1; j < n; j++) {
//                        if (countDistanceTwo(points[i][0], points[i][1], points[j][0], points[j][1]) < minvalue) {
//                            minvalue = countDistanceTwo(points[i][0], points[i][1], points[j][0], points[j][1]);
//                            begin = i;
//                            end = j;
//                        }
//                    }
//                }
//                if (points[begin][0] < points[end][0]) {
//
//                } else if (points[begin][0] > points[end][0]) {
//                    int temp_1 = end;
//                    end = begin;
//                    begin = temp_1;
//                } else {
//                    if (points[begin][1] > points[end][1]) {
//                        int temp_1 = end;
//                        end = begin;
//                        begin = temp_1;
//                    }
//                }
//                break;
//            }
//            case 3: {
//                for (int i = 0; i < n - 1; i++) {
//                    for (int j = i + 1; j < n; j++) {
//                        if (countDistanceThree(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]) < minvalue) {
//                            minvalue = countDistanceThree(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]);
//                            begin = i;
//                            end = j;
//                        }
//                    }
//                }
//                if (points[begin][0] < points[end][0]) {
//                } else if (points[begin][0] > points[end][0]) {
//
//                    int temp_1 = end;
//                    end = begin;
//                    begin = temp_1;
//                } else {
//                    if (points[begin][1] < points[end][1]) {
//
//                    } else if (points[begin][1] > points[end][1]) {
//                        int temp_1 = end;
//                        end = begin;
//                        begin = temp_1;
//                    } else {
//                        if (points[begin][2] < points[end][2]) {
//                        } else if (points[begin][2] > points[end][2]) {
//                            int temp_1 = end;
//                            end = begin;
//                            begin = temp_1;
//                        }
//                    }
//                }
//                break;
//            }
//        }
//        //此处用begin, end 序号代表
//        //part3
//        point[] points_2 = new point[n];
//        for (int i = 1; i <= n; i++) {
//            points_2[i - 1] = new point(points[i-1][0],points[i-1][1]);
//        }
//
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
//    static class comparator_x_two implements Comparator<Week10_Ques.point> {
//        @Override
//        public int compare(Week10_Ques.point p1, Week10_Ques.point p2) {
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
//    static class comparator_y_two implements Comparator<Week10_Ques.point> {
//        @Override
//        public int compare(Week10_Ques.point p1, Week10_Ques.point p2) {
//            if (p1.y > p2.y) {
//                return -1;
//            } else if (p1.y < p2.y) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }//大 → 小
//
//    public static long countDistanceTwo(long x1, long y1, long x2, long y2) {
//        long diffx = (x1 > x2 ? x1 - x2 : x2 - x1);
//        long diffy = (y1 > y2 ? y1 - y2 : y2 - y1);
//        return diffx * diffx + diffy * diffy;
//    }
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
