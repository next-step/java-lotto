package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoAllLine {

    private List<LottoOneLine> lottoAllLines;
    private String lastWeekWinnerNumber;
    private String bonusNumber;

    public LottoAllLine(List<LottoOneLine> lottoAllLines, String lastWeekWinnerNumber, String bonusNumber) {
        this.lottoAllLines = lottoAllLines;
        this.lastWeekWinnerNumber = lastWeekWinnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public double rateOfReturn(int inputLottoGamePrice) {
        return Math.floor((sumWinnerPrice() / (float) inputLottoGamePrice) * 100) / 100.0;
    }

    public int lottoSummaryWinnerCount(int eventWinnerPrice) {
        return lottoAllLines.stream()
                            .filter(lottoOne -> isEventWinnerPrice(lottoOne, eventWinnerPrice))
                            .collect(Collectors.toList())
                            .size();
    }

    private boolean isEventWinnerPrice(LottoOneLine lottoOneLine, int eventWinnerPrice) {
        return lottoOneLine.winnerPrice(lastWeekWinnerNumber, bonusNumber) == eventWinnerPrice;
    }

    private int sumWinnerPrice() {
        return lottoAllLines.stream()
                            .mapToInt(lotto -> lotto.winnerPrice(lastWeekWinnerNumber, bonusNumber))
                            .sum();
    }



}
