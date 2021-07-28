package lotto.view;

import lotto.domain.Lotto;

import java.util.Map;

public class ResultView {
    private static final int FIRST_REWARD = 20000000;
    private static final int SECOND_REWARD = 1500000;
    private static final int THIRD_REWARD = 50000;
    private static final int FORTH_REWARD = 5000;

    public void lottoList(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    public void printResult(Map<String, Object> resultMap, int price) {
        int first = (int) resultMap.get("first");
        int second = (int) resultMap.get("second");
        int third = (int) resultMap.get("third");
        int forth = (int) resultMap.get("forth");
        System.out.println("당첨 통계");

        System.out.println("-----------");

        System.out.println("1등(" + FIRST_REWARD + "원) : " + first + "개");
        System.out.println("2등(" + SECOND_REWARD + "원) : " + second + "개");
        System.out.println("3등(" + THIRD_REWARD + "원) : " + third + "개");
        System.out.println("4등(" + FORTH_REWARD + "원) : " + forth + "개");

        double result = ((first * FIRST_REWARD) + (second * SECOND_REWARD) + (third * THIRD_REWARD) + (forth * FORTH_REWARD)) / price;
        System.out.println("총 수익률은 : " + result + "입니다.");
    }

    public void printCount(int count) {
        System.out.println(count + "개 구매했습니다.");
    }
}
