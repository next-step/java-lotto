package views;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoContainer;

import java.util.ArrayList;
import java.util.List;

public class LottoContainerFormatter {

    private final List<LottoFormatter> lottoFormatters;

    public LottoContainerFormatter(LottoContainer lottoContainer) {
        List<LottoFormatter> lottoFormatters = new ArrayList<>();
        for (Lotto lotto: lottoContainer.getLottos()) {
            LottoFormatter lottoFormatter = new LottoFormatter(lotto.copyLottoNumbers());
            lottoFormatters.add(lottoFormatter);
        }
        this.lottoFormatters = lottoFormatters;
    }

    public String lottosAsString() {
        StringBuilder sb = new StringBuilder();
        for (LottoFormatter lottoFormatter : lottoFormatters) {
            String numbersAsString = lottoFormatter.numbersAsString();
            sb.append(numbersAsString).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
