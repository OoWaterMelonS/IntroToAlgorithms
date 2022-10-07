package sort.insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/7 周五
 * @desc  得到升序的排序结果
 */
public class InsertSort {
    public static void main(String[] args) {

          Integer[] arr = scanNum();
//        Integer[] arr = {3,2,1};


        System.out.println("排序前:" + Arrays.toString(arr));
        sort(arr);
        System.out.print("排序后:" + Arrays.toString(arr));

    }

    public static Integer[] scanNum(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("输入一串数字，空格分开，以#结束:");
        while (!sc.hasNext("#")) {
            int a = sc.nextInt();
            list.add(a);
        }
//       list 转 Integer : 提供首地址即可
        Integer[] arr = list.toArray(new Integer[0]);
        return arr;
    }


    public static void sort(Integer[] arr){

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //  将j到i-1的都后移一个位置
                if(arr[i] < arr[j]){
                    Integer temp = arr[i];
                    moveArr(arr,j,i);
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    public static void moveArr(Integer[] arr, int pre,int post){
        for (int j = post-1; j >=pre; j--) {
            arr[j+1] = arr[j];
        }
    }
}
