package lotto.domain;

import static lotto.domain.LottoTicket.ONE_TICKET_PRICE;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class LottoResults {

    private List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public int size() {
        return lottoResults.size();
    }

    public int countOf(final int fitCount) {
        return (int) lottoResults.stream()
            .filter(lottoResult -> lottoResult.fitCount() == fitCount)
            .count();
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Double getRoi() {
        df.setRoundingMode(RoundingMode.DOWN);

        int investmentMoney = lottoResults.size() * ONE_TICKET_PRICE;

        return Double.parseDouble(df.format(totalReturn() / investmentMoney));
    }

    private double totalReturn() {
        return lottoResults.stream()
            .mapToInt(LottoResult::reward)
            .sum();
    }

}
