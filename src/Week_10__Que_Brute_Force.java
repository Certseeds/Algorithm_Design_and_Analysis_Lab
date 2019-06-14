import java.util.Scanner;

public interface Week_10__Que_Brute_Force {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int demison = input.nextInt();
        int[][] points = new int[n][demison];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < demison; j++) {
                points[i][j] = input.nextInt();
            }
        }
        long minvalue = Long.MAX_VALUE;
        int begin = 1;
        int end = 1;
        switch (demison) {
            case 2: {
                for (int i = 0; i < n-1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (countDistanceTwo(points[i][0], points[i][1], points[j][0], points[j][1]) < minvalue) {
                            minvalue = countDistanceTwo(points[i][0], points[i][1], points[j][0], points[j][1]);
                            begin = i;
                            end = j;
                        }
                    }
                }
                System.out.println(minvalue + " " +begin + " " + end);
                if (points[begin][0] < points[end][0]) {
                    System.out.println(points[begin][0] + " " + points[begin][1]);
                    System.out.println(points[end][0] + " " + points[end][1]);
                } else if (points[begin][0] > points[end][0]) {
                    System.out.println(points[end][0] + " " + points[end][1]);
                    System.out.println(points[begin][0] + " " + points[begin][1]);
                } else {
                    if (points[begin][1] < points[end][1]) {
                        System.out.println(points[begin][0] + " " + points[begin][1]);
                        System.out.println(points[end][0] + " " + points[end][1]);
                    } else if (points[begin][1] > points[end][1]) {
                        System.out.println(points[end][0] + " " + points[end][1]);
                        System.out.println(points[begin][0] + " " + points[begin][1]);
                    }
                }
                break;
            }
            case 3: {
                for (int i = 1; i < n; i++) {
                    for (int j = i + 1; j <= n; j++) {
                        if (countDistanceThree(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]) < minvalue) {
                            minvalue = countDistanceThree(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]);
                            begin = i;
                            end = j;
                        }
                    }
                }
                if (points[begin][0] < points[end][0]) {
                    System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                    System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                } else if (points[begin][0] > points[end][0]) {
                    
                    System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                    System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                } else {
                    if (points[begin][1] < points[end][1]) {
                        System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                        System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                    } else if (points[begin][1] > points[end][1]) {
                        System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                        System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                    } else {
                        if (points[begin][2] < points[end][2]) {
                            System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                            System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                        } else if (points[begin][2] > points[end][2]) {
                            System.out.println(points[end][0] + " " + points[end][1] + " " + points[end][2]);
                            System.out.println(points[begin][0] + " " + points[begin][1] + " " + points[begin][2]);
                        }
                    }
                }
                break;
            }
            
        }
    }
    
    
    public static long countDistanceTwo(long x1, long y1, long x2, long y2) {
        long diffx = (x1 > x2 ? x1 - x2 : x2 - x1);
        long diffy = (y1 > y2 ? y1 - y2 : y2 - y1);
        return diffx * diffx + diffy * diffy;
    }
    
    public static long countDistanceThree(long x1, long y1, long z1, long x2, long y2, long z2) {
        long diffx = (x1 > x2 ? x1 - x2 : x2 - x1);
        long diffy = (y1 > y2 ? y1 - y2 : y2 - y1);
        long diffz = (z1 > z2 ? z1 - z2 : z2 - z1);
        return diffx * diffx + diffy * diffy + diffz * diffz;
    }
}
