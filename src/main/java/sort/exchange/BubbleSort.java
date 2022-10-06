package sort.exchange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ShaoYJ
 * @date 2022/10/6 周四
 * @desc 核心思想两两交换, 升序排列
 */
public class BubbleSort {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("输入一串数字，空格分开，以#结束:");
        while (!sc.hasNext("#")) {
            int a = sc.nextInt();
            list.add(a);
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}
