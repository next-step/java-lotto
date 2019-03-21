package lotto.view;

import lotto.domain.MatchLotto;
import lotto.domain.MyLotto;
import lotto.domain.Prize;

import java.util.List;

public class OutputView {

    private static final int PRICE = 1000;

    public static void issueLottoTickets(int money) {
        System.out.println(money / PRICE + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<MyLotto> myLottos) {
        for (MyLotto myLotto : myLottos) {
            System.out.println(myLotto.toString());
        }
    }

    public static void printResult(MatchLotto matchLotto) {
        int[] result = matchLotto.getMatchCounts();
        int bonusCount = matchLotto.getBonusCount();
        for (int i = 3; i < result.length; i++) {
            printMatchCount(i, result, matchLotto.getBonusCount());
        }
    }

    private static void printMatchCount(int i, int[] result, int bonusCount) {
        System.out.println(i + "개 일치 (" + Prize.getPrizeMoney(i, false) + ") - " + result[i] + "개");

        if (i == 5) {
            System.out.println(i + "개 일치, 보너스 볼 일치(" + Prize.getPrizeMoney(i, true) + ") - " + bonusCount + "개");
        }
    }

    public static void printRate(double rate) {

        String result = "총 수익률은 " + String.format("%.2f", rate) + "입니다.";
        if (rate < 0) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(result);
    }
}
