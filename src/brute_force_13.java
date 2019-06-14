import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class brute_force_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] now = new int[n + 1];
        int[] max = new int[n + 1];
        int peopleNumber = 0;
        int maxClass_room = 0;
        int count = 0;
        int []arr = new int[n];
        int nLen = n;
        for (int i = 1; i <= n; i++) {
            now[i] = input.nextInt();
            max[i] = input.nextInt();
        }
        for (int i = 0;i<n;i++){
            arr[i] = i+1;
        }
        
        //
        int [] temp = Arrays.copyOfRange(max,1,n+1);
        Arrays.sort(temp);
        for (int i = n-1;i>=0;i--){
            count += temp[i];
            maxClass_room++;
            if (count >= peopleNumber){
                break;
            }
        }
        //
        int m = maxClass_room;
        int []out = new int[m];
        ArrayList<int[]> temp_2 = new ArrayList<>();
    
        Combination(temp_2,6,arr,10,6,out,6);
        Combination(temp_2,maxClass_room,arr,nLen,m,out,m);
        for (int i = 0;i<temp_2.size();i++){
            System.out.println(Arrays.toString(temp_2.get(i)));
        }
//
//        int peopleNumber = 0;
//        int maxvolume = 0;
//
//        int[] temp = Arrays.copyOfRange(max, 1, n + 1);
//        Arrays.sort(temp);
//        int maxClass_room = 0;
//        int count = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            count += temp[i];
//            maxClass_room++;
//            if (count >= peopleNumber) {
//                break;
//            }
//        }
//        //maxClass_room就是需要的总数
//        ArrayList<Integer> mans = new ArrayList<>();
//        int maxvalue1 = 0;
//        for (int i = 1; i <= 7; i++) {
//            for (int j = i; j <= 8; j++) {
//                for (int k = j; k <= 9; k++) {
//                    for (int l = k; l <= 10; l++) {
//                        if (max[i] + max[j] + max[k] + max[l] >= peopleNumber) {
//                            maxvalue1 = Math.max(maxvalue1, now[i] + now[j] + now[k] + now[l]);
//                            System.out.println(i + " " + j + " "+ k +" " + l );
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(maxvalue1);
        
        
    }
    public static  ArrayList<int[]>  Combination( ArrayList<int[]> temp ,int max_class,int arr[], int nLen, int m, int out[], int outLen)
    {
        if(m == 0)
        {   temp.add(Arrays.copyOfRange(out,0,max_class));
           // System.out.println(Arrays.toString(out));
            return null;
        }
        
        for (int i = nLen; i >= m; --i)	//从后往前依次选定一个
        {
            out[m-1] = arr[i-1]; //选定一个后
            Combination(temp, max_class,arr,i-1,m-1,out,outLen); // 从前i-1个里面选取m-1个进行递归
        }
        return temp;
    }
}
