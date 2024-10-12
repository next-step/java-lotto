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
        writer.write("3개 일치 (" + LottoRank.FIFTH.getWinningPrice() + "원) - " + results.winningCount(LottoRank.FIFTH) + "개");
        writer.write("4개 일치 (" + LottoRank.FOURTH.getWinningPrice() + "원) - " + results.winningCount(LottoRank.FOURTH) + "개");
        writer.write("5개 일치 (" + LottoRank.THIRD.getWinningPrice() + "원) - " + results.winningCount(LottoRank.THIRD) + "개");
        writer.write("5개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getWinningPrice() + "원) - " + results.winningCount(LottoRank.SECOND) + "개");
        writer.write("6개 일치 (" + LottoRank.FIRST.getWinningPrice() + "원) - " + results.winningCount(LottoRank.FIRST) + "개");
    }

    public void displayRate(final LottoStatistics statistics) {
        writer.write("총 수익률은 " + String.format("%.2f", statistics.rate()) + "입니다.");
    }
}
