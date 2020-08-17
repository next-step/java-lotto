package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoResult;
import kr.heesu.lotto.domain.MultipleLotto;
import kr.heesu.lotto.domain.PurchaseAmount;
import kr.heesu.lotto.enums.LottoPolicy;
import kr.heesu.lotto.enums.Message;

import java.io.PrintWriter;
import java.util.Map;

public class ResultView {
    private static final Double STANDARD = 1.0;
    private final PrintWriter writer;

    private ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printLottoResult(LottoResult result) {
        printMatchResult(result);
        printProfitRate(result);
    }

    private void printMatchResult(LottoResult result) {
        Map<Long, Long> matches = result.getMatches();

        for (LottoPolicy policy : LottoPolicy.values()) {
            Long count = policy.getCount();
            Long price = policy.getPrice();
            Long actualMatch = matches.get(count);

            writer.println(String.format(Message.OUTPUT_FORMAT_FOR_MATCH_RESULT.of(), count, price, actualMatch));
        }
    }

    private void printProfitRate(LottoResult result) {
        Double profitRate = result.getProfitRate();
        writer.print(String.format(Message.OUTPUT_FORMAT_FOR_PROFIT_RATE.of(), profitRate));

        if (profitRate < STANDARD) {
            writer.println(Message.OUTPUT_FOR_PROFIT_RATE_LOSS.of());
            return;
        }
        writer.println(Message.OUTPUT_FOR_PROFIT_RATE_BENEFIT.of());
    }

    public void printMultipleLotto(MultipleLotto multipleLotto) {
        writer.println(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount) {
        int size = amount.getSize();
        writer.println(String.format(Message.OUTPUT_FORMAT_FOR_PURCHASE_SIZE.of(), size));
    }

    public static ResultView of() {
        return new ResultView();
    }
}
