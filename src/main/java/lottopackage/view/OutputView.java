package lottopackage.view;

import lottopackage.domain.Lotto;
import lottopackage.domain.Prize;

import java.util.*;

public class OutputView {

    public static void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "장을 구매했습니다.");
    }

    public static void printLottoGroup(List<Lotto> lottoGroup) {
        for (int i = 0; i < lottoGroup.size(); i++) {
            System.out.println(lottoGroup.get(i));
        }
    }

    public static void printLottoResult(List<Prize> lottoResult, int totalLottoGroupSize) {
        List<Prize> prizeGroup = Arrays.asList(Prize.values());
        int totalWinningAmount = 0;

        System.out.println("당첨 통계");
        System.out.println("--------");

        for (int i = 0; i < prizeGroup.size(); i++) {
            Prize prize = prizeGroup.get(i);
            String second = (prize == Prize.SECOND) ? "보너스 볼 일치 - " : "";
            System.out.println(prize.getBall() + "개 일치 ("
                    + prize.getWinningAmount() + "원)- " + second
                    + Collections.frequency(lottoResult, prize) + "개");
            totalWinningAmount += (prize.getWinningAmount()) * (Collections.frequency(lottoResult, prize));
        }

        System.out.println("총 수익률은 " + (float) totalWinningAmount / (totalLottoGroupSize * 1000) + " 입니다.");
    }
}
