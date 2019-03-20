package lotto.view;

import lotto.Lotto;
import lotto.Prize;

import java.util.List;

public class OutputView {

    private static final int PRICE = 1000;

    public static void issueLottoTickets(int money) {
        System.out.println(money/PRICE + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printMatchCount(int[] result) {
        for (int i = 3; i < result.length; i++) {
            System.out.println(i + "개 일치 (" + Prize.getPrizeMoney(i) + ") - " + result[i] + "개");
        }
    }

    public static void printRate(double rate) {

        String result = "총 수익률은 " + String.format("%.2f", rate)+ "입니다.";
        if (rate < 0) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(result);
    }
}
