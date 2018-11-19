package view;

import domain.LottoCountManager;
import domain.Rank;
import domain.Lotto;
import domain.LottoResult;

import java.util.List;

public class ResultView {
    public static void showBoughtLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString()+"\n");
    }

    public static void howManyBoughtLotto(LottoCountManager lottoCountManager) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                lottoCountManager.manualCount(),
                lottoCountManager.autoCount())
        );
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
            sb.append(String.format(matchedFormat(rank), rank.getMatchNumber(), rank.getPrizeMoney(), matchCount));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String matchedFormat(Rank rank) {
        String matchedFormat = "%d개 일치 (%d원) - %d개";
        if (rank.equals(Rank.SECOND)) {
            matchedFormat = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
        }
        return matchedFormat;
    }

    private static void showRate(LottoResult lottoResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResult.calculatorRate()));
    }
}
