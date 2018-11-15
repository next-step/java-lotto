package view;

import domain.Lotto;
import domain.LottoPapers;

public class ResultView {
    static final int FOURREWARD = 5000;
    static final int THIRREWARD = 50000;
    static final int SECREWARD = 1500000;
    static final int FIRREWARD = 2000000000;
    static final int MATCHTHREE = 3;
    static final int MATCHFOUR = 4;
    static final int MATCHFIVE = 5;
    static final int MATCHSIX = 6;
    static final int numberOfRewards = 4;

    public static void printLottoNumbers(LottoPapers lottoPapers) {
        for(Lotto lotto : lottoPapers.putLottoPapers()) {
            System.out.println(lotto.putLottoNumber());
        }
        System.out.println();
    }

    public static void printResult(int[] values, int money) {
        int rewardArr[] = {FOURREWARD, THIRREWARD, SECREWARD, FIRREWARD};
        double ratio = calculateBenefit(values, money);
        double matchArr[] = new double[numberOfRewards];
        int numberMatchingArr[] = {MATCHTHREE, MATCHFOUR, MATCHFIVE, MATCHSIX};

        for(int i = 0; i < numberOfRewards; i++) {
            matchArr[i] = values[i];
        }

        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---------");

        for(int i = 0; i < numberOfRewards; i++) {
            System.out.print(numberMatchingArr[i]+"개 일치 ("+rewardArr[i]+"원)- ");
            System.out.println((int)matchArr[i] + "개");
        }

        System.out.println("총 수익률은 " + ratio + "입니다.");
    }

    private static double calculateBenefit(int[] values, int money) {
        return (int)((double)( values[0] * FOURREWARD +
                values[1] * THIRREWARD +
                values[2] * SECREWARD +
                values[3] * FIRREWARD) / (double)(money)*100)/100.0;
    }

    public static void printNumberOfLottos(int turn) {
        System.out.println(turn + "개를 구매했습니다.");
    }
}
