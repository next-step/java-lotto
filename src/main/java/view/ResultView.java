package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Lotto;
import domain.LottoStatics;
import domain.Rank;

import static domain.LottoStatics.PROFIT_STANDARD;
import static domain.Rank.FIFTH;
import static domain.Rank.FIRST;
import static domain.Rank.FOURTH;
import static domain.Rank.SECOND;
import static domain.Rank.THIRD;

public class ResultView {

    private static void print(Lotto lotto) {
        String formatted = lotto.getNumList().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + formatted + "]");
    }

    public static void print(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            print(lotto);
        }
    }

    public static void print(LottoStatics lottoStatics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        FIFTH.print(lottoStatics);
        FOURTH.print(lottoStatics);
        THIRD.print(lottoStatics);
        SECOND.print(lottoStatics);
        FIRST.print(lottoStatics);

        System.out.println("총 수익률은 " + lottoStatics.getProfitRate()
            + "입니다.(기준이 " + PROFIT_STANDARD
            + "이기 때문에 결과적으로 "
            + (lottoStatics.isProfit() ? "이익" : "손해" + "라는 의미임"));
    }
}
