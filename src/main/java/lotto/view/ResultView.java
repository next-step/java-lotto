package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {
    private static final Rank FIRST = Rank.FIRST;
    private static final Rank SECOND = Rank.SECOND;
    private static final Rank THIRD = Rank.THIRD;
    private static final Rank FORTH = Rank.FORTH;
    private static final Rank FIFTH = Rank.FIFTH;

    private final int firstReward = FIRST.getReward();
    private final int secondReward = SECOND.getReward();
    private final int thirdReward = THIRD.getReward();
    private final int forthReward = FORTH.getReward();
    private final int fifthReward = FIFTH.getReward();

    public void lottoList(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    public void printResult(Map<Rank, Integer> resultMap, int price) {
        int first = resultMap.get(FIRST);
        int second = resultMap.get(SECOND);
        int third = resultMap.get(THIRD);
        int forth = resultMap.get(FORTH);
        int fifth = resultMap.get(FIFTH);

        System.out.println("당첨 통계");

        System.out.println("-----------");

        System.out.println("1등(" + firstReward + "원) : " + first + "개");
        System.out.println("2등(" + secondReward + "원) : " + second + "개");
        System.out.println("3등(" + thirdReward + "원) : " + third + "개");
        System.out.println("4등(" + forthReward + "원) : " + forth + "개");
        System.out.println("5등(" + fifthReward + "원) : " + forth + "개");

        double result = ((first * firstReward) + (second * secondReward) + (third * thirdReward) + (forth * forthReward) + (fifth * fifthReward)) / price;
        System.out.println("총 수익률은 : " + result + "입니다.");
    }

    public void printCount(int count, int manualCount) {
        System.out.println("수동 " + manualCount + "개, 자동 " + count + "개 구매했습니다.");
    }
}
