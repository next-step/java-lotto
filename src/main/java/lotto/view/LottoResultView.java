package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinningResults;
import lotto.io.MessageWriter;

public class LottoResultView {
    private final MessageWriter writer;
    private final LottoWinningResults results;

    public LottoResultView(final MessageWriter writer,
                           final LottoWinningResults results) {
        this.writer = writer;
        this.results = results;
    }

    public void display() {
        writer.write("당첨 통계");
        writer.write("---------");
        writer.write("3개 일치 (" + LottoRank.fifth().getWinningPrice() + "원) - " + results.winningCount(LottoRank.fifth()) + "개");
        writer.write("4개 일치 (" + LottoRank.fourth().getWinningPrice() + "원) - " + results.winningCount(LottoRank.fourth()) + "개");
        writer.write("5개 일치 (" + LottoRank.third().getWinningPrice() + "원) - " + results.winningCount(LottoRank.third()) + "개");
        writer.write("6개 일치 (" + LottoRank.first().getWinningPrice() + "원) - " + results.winningCount(LottoRank.first()) + "개");
    }

    public void displayRate(final LottoStatistics statistics) {
        writer.write("총 수익률은 " + String.format("%.2f", statistics.rate()) + "입니다.");
    }
}
