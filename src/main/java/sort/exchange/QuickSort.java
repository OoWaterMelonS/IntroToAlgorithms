package sort.exchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/27 周四
 * @desc 得到升序结果
 */
public class QuickSort {
    public static void main(String[] args) {
        // Integer[] arr = scanNum();
        Integer[] arr = {6, 54, 32, 21, 9, 100};
        // Integer[] arr = {5,4,3,2,1};
        System.out.println("排序前:" + Arrays.toString(arr));
        System.out.println("排序后:" + Arrays.toString(quickSort(arr, 0, arr.length-1)));
    }

    public static Integer[] scanNum() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("输入一串数字，空格分开，以#结束:");
        while (!sc.hasNext("#")) {
            int a = sc.nextInt();
            list.add(a);
        }
//       list 转 Integer : 提供首地址即可
        return list.toArray(new Integer[0]);
    }

    public static Integer[] quickSort(Integer[] arr, int low, int high) {
        if (low > high) {
            return arr;
        }
        int i = low;
        int j = high;
        Integer t;
        //  基址对应元素值
        Integer temp = arr[low];
        //  来回进行交换
        while (i < j) {
//            先从后向前遍历找到符合条件的值
            while (temp <= arr[j] && i < j) {
                j--;
            }
//           从前往后遍历找到符合条件的值
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);

        return arr;
    }



}
