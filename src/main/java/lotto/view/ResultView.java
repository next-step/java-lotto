package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatics;
import lotto.domain.Lottos;
import lotto.domain.Profit;

import java.io.PrintStream;

public class ResultView {
    private static final int MIN_STATIC_RANK = 3;
    private static final int[] RANK_PRIZE = new int[] {0,0,0,5_000,50_000,1_500_000,2_000_000_000};

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
        buffer.append("당첨 통계").append(ENTER)
                .append("---------").append(ENTER);
        for(int rank = MIN_STATIC_RANK; rank <= Lotto.NUMBER_COUNT; rank++) {
            buffer.append(rank)
                    .append("개 일치 (")
                    .append(RANK_PRIZE[rank])
                    .append(")- ")
                    .append(statics.getRankCount(rank))
                    .append("개").append(ENTER);
        }
        buffer.append("총 수익률은 ").append(profit).append("입니다.");
        view.println(buffer);
    }
}
