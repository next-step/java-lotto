package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoStatistics;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.enums.LottoPolicy;

import java.io.PrintWriter;

public class ResultView {
    private static final Double STANDARD = 1.0;
    private final PrintWriter writer;

    private ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printLottoStatistics(LottoStatistics result) {
        printMatchResult(result);
        printProfitRate(result);
    }

    private void printMatchResult(LottoStatistics result) {

        for (LottoPolicy policy : LottoPolicy.values()) {
            Long count = policy.getCount();
            Long price = policy.getPrice();
            Long frequency = result.getMatchFrequency(count);

            writer.println(String.format(ViewMessage.OUTPUT_FORMAT_FOR_MATCH_RESULT.getMessage(), count, price, frequency));
        }
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

    public void printMultipleLotto(Lottos multipleLotto) {
        writer.println(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount) {
        int size = amount.getSize();
        writer.println(String.format(ViewMessage.OUTPUT_FORMAT_FOR_PURCHASE_SIZE.getMessage(), size));
    }

    public static ResultView of() {
        return new ResultView();
    }
}
