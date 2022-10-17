package sort.insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/17 周一
 * @desc 得到升序结果
 */
public class ShellSort {
    public static void main(String[] args) {
//        Integer[] arr = scanNum();
        Integer[] arr = {6,54,32,21,9,100};
//        Integer[] arr = {5,4,3,2,1};


        System.out.println("排序前:" + Arrays.toString(arr));
        sort(arr);
        System.out.print("排序后:" + Arrays.toString(arr));
    }

    private static void sort(Integer[] arr) {
        int len = arr.length;
        int gap = (len + 1) / 2;
        boolean flag = true;
        while (gap >=1) {
//            i 表示第一个gap前的数字
            for (int i = 0; i < gap; i++) {
//               循环每次的增量都是当前的gap数值
                for (int j = i + gap; j < len; j += gap) {
//                       本组内部  从后往前采用 插入排序，实现数据的升序排列
                    for (int k = j - gap; k >= i; k -= gap) {
                        if (arr[j] < arr[k]) {
//                          当前点的值小于前面点的值 向后移
                            int tmp = arr[j];
                            arr[j] = arr[k];
                            arr[k] = tmp;
                        }
                    }
                }
            }
            //   此处gap+1 是为了保证当gap为奇数的时候，实现向上取整
            gap = (gap+1) / 2;
//          此处由于设计的是 gap = (gap+1)/2 所以 gap会在等于1的时候不能正确退出，因此设置一个标志量，用于限制gap=1只能在while中走一次
            if(!flag){
                break;
            }

            if(gap==1){
                flag = false;
            }
        }
//        增量从length/2开始，然后增量依次缩小为一半


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
