package sort.select;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/26 周三
 * @desc 得到升序结果
 */
public class SelectSort {

    public static void main(String[] args) {
//        Integer[] arr = scanNum();
        Integer[] arr = {8,1,3,2,5,4};
        sort(arr);
    }

    private static  void  sort(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
//            让min始终跟踪绑定最小值的索引
            for (int j = i+1; j < len; j++) {
                if(arr[min]>arr[j]) {
                    min = j;
                }
            }
//            交换当前位和最小位置上的值
            if(min!=i) {
                Integer tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        for (Integer i:arr ) {
            System.out.print(i);
        }
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
}
