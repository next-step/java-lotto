package views;

import java.util.List;

public class LottoContainerFormatter {

    private final List<LottoFormatter> lottoFormatters;

    public LottoContainerFormatter(List<LottoFormatter> lottoFormatters) {
        this.lottoFormatters = lottoFormatters;
    }

    public String lottosAsString() {
        StringBuilder sb = new StringBuilder();
        for (LottoFormatter lottoFormatter : lottoFormatters) {
            String numbersAsString = lottoFormatter.numbersAsString();
            sb.append(numbersAsString).append("\n");
        }
        return sb.toString();
    }
}
