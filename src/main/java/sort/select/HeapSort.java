package sort.select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/7 周五
 * @desc 选择排序的一种，主要分为三步，
 * 1. 构建一个堆
 * 2. 将堆顶元素与末尾元素交换
 * 3. 重新调整结构，2和3交替执行
 */
public class HeapSort {
    public static void main(String[] args) {
//       输入测试参数
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.print("输入一串数字，空格分开，以#结束:");
//        while (!sc.hasNext("#")) {
//            int a = sc.nextInt();
//            list.add(a);
//        }
//        Integer[] arr = new Integer[list.size()];
//        list.toArray(arr);

//        Integer[] arr = {6, 5, 4, 3, 2, 1};
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序前：" + Arrays.toString(arr));
    }

    public static void sort(Integer[] arr) {
        /**
         * 第一步 ：构建大顶堆
         *  1. 堆可以看为完全二叉树，
         *  2. 从最后一个非叶子节点开始从下往上， 从右向左构建
         *  3. 因此 索引i的初始值为最后一个非叶子节点的索引
         *  4. 从arr的后面往前移动一个一个大调整堆
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //2,3步 => 调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            //第二步 ： 将堆顶元素与末尾元素进行交换
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            // 第三步 ：只需要对剩余的元素重新进行调整
            adjustHeap(arr, 0, j-1);
        }

    }

    /**
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(Integer[] arr, int i, int length) {
//        把根节点的值保存下来。
        int temp = arr[i];
        /*
         * 从i结点的左子结点开始，也就是2i+1处开始,
         * 存在一层调整后，下一层不满足的情况，需要把整棵子树都调整
         * 例如 子树为 1 5 3 2 -》 1和 5交换之后，5 1 3 2 ，还要继续 交换2*i+1 【数值1】和 2*(2*i+1)+1 【数值2】
         */
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 如果存在右孩子节点， 指针需要指向大的子节点
            if(j+1<length){
                j = arr[j] > arr[j + 1] ? j : j + 1;
            }
//           如果子节点的值大于根节点，交换值
            if (arr[j] > temp) {
//                父节点的值修改为子节点值
                arr[i] = arr[j];
//                子节点值设置为原本父节点的值
                arr[j] = temp;
//                及时同步原本父节点的指针为子节点指针，并开始下一轮调整
                i = j;
            }
//           根节点>大的那个子节点  即 根节点大于所有节点
            else {
                break;
            }

        }
    }
}