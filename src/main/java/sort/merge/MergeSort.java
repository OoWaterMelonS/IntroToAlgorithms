package sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/29 周六
 * @desc 得到升序排序
 */
public class MergeSort {
    public static void main(String[] args) {
        // Integer[] arr = scanNum();
        Integer[] arr = {6, 5, 4, 3, 2, 1};
        System.out.println("排序前:" + Arrays.toString(arr));
        // Integer[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("排序后:" + Arrays.toString(arr));
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

    public static void merge(Integer[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = 0;
        int j = low, k = mid + 1;
//        先将小的值交替从arr前后序列中提取出来，放到tmp中
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }

//        处理完剩余的值，放到tmp中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }

//        将排序好的tmp覆盖赋予arr
        for (int l = 0; l < tmp.length; l++) {
            arr[low + l] = tmp[l];
        }
    }

    public static void mergeSort(Integer[] arr, int low, int high) {
//      递归调用
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }


}
