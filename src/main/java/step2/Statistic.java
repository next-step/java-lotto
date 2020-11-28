package step2;

import java.util.List;

public class Statistic {
    public static final Integer[] rewardList = {5000, 50000, 1500000, 2000000000};
    public static final Integer[] results = {0, 0, 0, 0};

    public static String getRewardResult(String winningNumber) {
        int index = Integer.parseInt(winningNumber)-3;
        return winningNumber + "개 일치 ("+rewardList[index].toString()+"원)- "+results[index].toString()+"개";
    }

    public static float getMargin(int money) {
        float totalReward = 0;
        for(int i = 0; i < rewardList.length; i++) {
            totalReward += rewardList[i] * results[i];
        }

        return totalReward/money;
    }

    public static void recordResult(int winningNumber) {
        if(winningNumber > 2) {
            results[winningNumber-3] += 1;
        }
    }
}
