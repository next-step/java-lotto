/*
 * ResultView.java
 *
 * version 1.0
 *
 * 2023/05/01
 *
 * This software is the confidential and proprietary information of Nayoung Kim
 */

package step2;

public class ResultView {

    private static final int[] LOTTO_AMOUNT = {5000, 50000, 1500000, 2000000000};

    public void printResult(int[] result){
        int totalMoney = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계");
        sb.append("---------");
        for(int i=2;i<result.length;i++){
            int earnMoney = LOTTO_AMOUNT[i]*(i-2);
            sb.append((i+1)).append("개 일치 (").append(earnMoney).append("원)- ").append(result[i]).append("개").append("\n");
            totalMoney += earnMoney;
        }

        System.out.println(sb.toString());
        //return sb.toString();
    }
}
