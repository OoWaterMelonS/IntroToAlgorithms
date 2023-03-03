package filtering_algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ShaoYJ
 * @date 2023/2/18 周六
 * @desc 线性卡尔曼滤波代码
 */
public class LinearKalmanFilter {
    private final double Q = 0.000001;
    private final double R = 0.001;
    private ArrayList<Double>  dataArrayList;
    private int dataLength;

    // 测量值
    private double z[];
    // 修正值
    private double xHat[];
    // 预测值
    private double xHatMinus[];
    // 误差协方差矩阵
    private double P[];
    // 临时误差协方差矩阵
    private double PMinus[];
    // 卡尔曼增益
    private double K[];

    public LinearKalmanFilter(ArrayList<Double> arrayList){
        this.dataArrayList = arrayList;
        this.dataLength = arrayList.size();
        z = new double[dataLength];
        xHat = new double[dataLength];
        xHatMinus = new double[dataLength];
        P = new double[dataLength];
        PMinus = new double[dataLength];
        K = new double[dataLength];
        xHat[0]=0;
        P[0] = 1.0;

        // 预处理测量数据
        for (int i = 0; i < dataLength; i++) {
            z[i] = (double) dataArrayList.get(i);
        }
    }

    public ArrayList<Double> iterate(){
        if(dataArrayList.size()<2){
            return dataArrayList;
        }
        for (int k = 1; k < dataLength; k++) {
            /* 状态转移
             X(k|k-1) = AX(k-1|k-1) + BU(k) + W(k),
             A=1,BU(k) = 0
             */
            xHatMinus[k] = xHat[k-1];

            /*
            误差协方差矩阵
            P(k|k-1) = A*P(k-1|k-1)*A' + Q(k) ,
            A=1
             */
            PMinus[k] = P[k-1]+Q;

            /*
            计算kalman  gain
            Kg(k)=P(k|k-1)* H'  /   ([H*P(k|k-1)*H' + R]),
            H=1
             */
            K[k] = PMinus[k] /(PMinus[k]+R);

            /*
            更新预测值
            X(k|k) = X(k|k-1) + Kg(k)[Z(k) - HX(k|k-1)],
             H=1
             */
            xHat[k] = xHatMinus[k] + K[k] * (z[k]-xHatMinus[k]);
            
            /*
            更新误差协方差矩阵
             */
            P[k] = (1-K[k])*PMinus[k];

        }

        for (int i = 0; i < dataLength; i++) {
            dataArrayList.set(i,xHat[i]);
        }
        dataArrayList.remove(0);
        return dataArrayList;
    }

    public static void main(String[] args) {
        int length = 20;
        ArrayList<Double> measureData = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            measureData.add((double)random.nextInt(3)+i*10);
        }
        System.out.println(measureData);
        LinearKalmanFilter linearKalmanFilter = new LinearKalmanFilter(measureData);
        ArrayList<Double> doubleArrayList = linearKalmanFilter.iterate();
        System.out.println(doubleArrayList.toString());
    }
}
