package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    public static final String MSG_PURCHASE_NUMBER = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    public static final String MSG_WINNING_RESULT = "당첨 통계";
    public static final String DOTTED_LINE_MARK = "---------";
    public static final String MSG_SAME_COUNT = "%d개 일치 %s(%d원) - %d개\n";
    public static final String MSG_MATCH_BONUS = ", 보너스 볼 일치";
    public static final String MSG_PROFIT_RATE = "총 수익률은 %.2f 입니다.\n";

    public static void printPurchaseNumber(LottoGame lottoGame) {
        System.out.printf(MSG_PURCHASE_NUMBER, lottoGame.getManualLottos().lottosSize(), lottoGame.getAutoCount());

    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = lotto.getLottoNumbers().stream().map(lottoNumber -> Integer.toString(lottoNumber.getNumber())).collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbers + "]");
        }
        System.out.println();
    }

    public static void printWinningResult(LottoResults lottoResults) {
        System.out.println();
        System.out.println(MSG_WINNING_RESULT);
        System.out.println(DOTTED_LINE_MARK);

        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            String matchBonus = rank == Rank.SECOND ? MSG_MATCH_BONUS : "";
            System.out.printf(MSG_SAME_COUNT, rank.getMatchCount(), matchBonus, rank.getReward(), lottoResults.getRankCount(rank));
        }
    }

    public static void printProfitRate(LottoResults lottoResults, int totalLottoCnt) {
        System.out.printf(MSG_PROFIT_RATE, lottoResults.getProfitRate(totalLottoCnt));
    }
}
