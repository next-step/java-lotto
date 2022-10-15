package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.RankMap;

import java.util.stream.Collectors;

public class ResultView {

    public static final String MSG_PURCHASE_NUMBER = "개를 구매했습니다.";
    public static final String MSG_WINNING_RESULT = "당첨 통계";
    public static final String DOTTED_LINE_MARK = "---------";
    public static final String MSG_SAME_COUNT = "%d개 일치 %s(%d원) - %d개\n";
    public static final String MSG_MATCH_BONUS = ", 보너스 볼 일치";
    public static final String MSG_PROFIT_RATE = "총 수익률은 %.2f 입니다.\n";

    public static void printPurchaseNumber(int n) {
        System.out.println(n + MSG_PURCHASE_NUMBER);

    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            String lottoNumbers = lotto.getLottoNumbers().stream().map(lottoNumber -> Integer.toString(lottoNumber.getNumber())).collect(Collectors.joining(", "));
            System.out.println("[" + lottoNumbers + "]");
        }
        System.out.println();
    }

    public static void printWinningResult(RankMap rankMap) {
        System.out.println();
        System.out.println(MSG_WINNING_RESULT);
        System.out.println(DOTTED_LINE_MARK);

        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            String matchBonus = rank == Rank.SECOND ? MSG_MATCH_BONUS : "";
            System.out.printf(MSG_SAME_COUNT, rank.getMatchCount(), matchBonus, rank.getReward(), rankMap.getRankCount(rank));
        }
    }

    public static void printProfitRate(RankMap rankMap, int totalLottoCnt) {
        System.out.printf(MSG_PROFIT_RATE, rankMap.getProfitRate(totalLottoCnt));
    }
}
