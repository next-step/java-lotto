package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoStatistics;
import kr.heesu.lotto.domain.ManualCount;
import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.enums.Rank;

import java.io.PrintWriter;

public class ResultView {
    private static final Double STANDARD = 1.0;
    private final PrintWriter writer;

    private ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    private static class InnerHolder {
        private static final ResultView INSTANCE = new ResultView();
    }

    public static ResultView getInstance() {
        return InnerHolder.INSTANCE;
    }

    public void printLottoStatistics(LottoStatistics result) {
        printMatchResult(result);
        printProfitRate(result);
    }

    private void printMatchResult(LottoStatistics result) {

        for (Rank rank : Rank.values()) {
            Long count = rank.getCountOfMatch();
            Long price = rank.getWinningMoney();
            Long frequency = result.getRankFrequency(rank);

            printFormatLine(getFormat(rank), count, price, frequency);
        }
    }

    private String getFormat(Rank rank) {
        return rank.equals(Rank.SECOND) ? ViewMessage.OUTPUT_FORMAT_FOR_SECOND_RANK.getMessage() : ViewMessage.OUTPUT_FORMAT_FOR_MATCH_RESULT.getMessage();
    }

    private void printFormatLine(String format, Long count, Long price, Long frequency) {
        if (count.equals(0L)) {
            return;
        }
        writer.println(String.format(format, count, price, frequency));
    }

    private void printProfitRate(LottoStatistics result) {
        Double profitRate = result.getProfitRate();
        writer.print(String.format(ViewMessage.OUTPUT_FORMAT_FOR_PROFIT_RATE.getMessage(), profitRate));

        if (profitRate < STANDARD) {
            writer.println(ViewMessage.OUTPUT_FOR_PROFIT_RATE_LOSS.getMessage());
            return;
        }
        writer.println(ViewMessage.OUTPUT_FOR_PROFIT_RATE_BENEFIT.getMessage());
    }

    public void printMultipleLotto(String multipleLotto) {
        writer.println(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount, ManualCount count) {
        int manualSize = count.getSize();
        int autoSize = amount.getSize() - manualSize;
        writer.println(String.format(ViewMessage.OUTPUT_FORMAT_FOR_PURCHASE_SIZE.getMessage(), manualSize, autoSize));
    }
}
