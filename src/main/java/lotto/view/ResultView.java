package lotto.view;

import lotto.domain.*;

import java.io.PrintStream;
import java.util.Map;

public class ResultView {
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";

    PrintStream view = new PrintStream(System.out);
    private String ENTER = System.lineSeparator();
    public void enter() {
        view.println("");
    }

    public void println(Object obj) {
        view.println(obj);
    }

    public void showLottoGames(Lottos lottos) {
        for (Lotto game : lottos) {
            println(game);
        }
        enter();
    }

    public void showLottoStatics(LottoStatics statics) {

        StringBuffer buffer = new StringBuffer();
        Profit profit = statics.getProfit();
        buffer.append(ENTER).append("당첨 통계").append(ENTER)
                .append("---------").append(ENTER);
        Map<Rank,Integer> rankCounts = statics.rankCounts();
        for ( Rank rank: Rank.values()) {
            appendStatics(buffer,rank,rankCounts.get(rank));
        }

        buffer.append("총 수익률은 ").append(profit).append("입니다.");
        view.println(buffer);
    }

    private void appendStatics(StringBuffer buffer, Rank rank, Integer count) {
        if( rank == Rank.nothing) {
            return;
        }
        buffer.append(rank.matchCount())
                .append("개 일치");
        if (rank == Rank.fiveNumbersMatchWithBonusNumber) {
            buffer.append(BONUS_MATCH_MESSAGE);
        }
        buffer.append(" (")
                .append(rank.prize())
                .append("원)- ")
                .append(count)
                .append("개")
                .append(ENTER);
    }
}
