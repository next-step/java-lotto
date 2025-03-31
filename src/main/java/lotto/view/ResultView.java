package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;

import java.util.List;

public class ResultView {

    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + LottoPrize.getPrizeByMatchCount(i) + "원)- " + result.getMatchCounts().getOrDefault(i, 0) + "개");
        }
        System.out.printf("총 수익률은 %,.2f입니다.%n", result.getRate());
    }
}
