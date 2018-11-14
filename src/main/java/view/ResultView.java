package view;

import domain.Rank;
import domain.Lotto;
import domain.LottoResult;

import java.util.List;

public class ResultView {

    public static void showBoughtLottos(List<Lotto> lottos) {
        howManyBoughtLotto(lottos.size());

        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString()+"\n");
    }

    private static void howManyBoughtLotto(int sizeOfLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", sizeOfLotto));
    }

    public static void showResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---------");
        showMatches(lottoResult);
        showRate(lottoResult);
    }

    private static void showMatches(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : lottoResult.getRanks()) {
            int matchCount = lottoResult.matchCount(rank);
            sb.append(String.format("%d개 일치 (%d원) - %d개", rank.getMatchNumber(), rank.getPrizeMoney(), matchCount));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void showRate(LottoResult lottoResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculatorRate()));
    }
}
