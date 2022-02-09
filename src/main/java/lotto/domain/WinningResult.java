package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private final List<WinningNumber> winningNumbers;
    private final List<LottoTicket> lottoTickets;
    private int winningCount;
    private boolean hasBonus;

    public WinningResult(List<WinningNumber> winningNumbers) {
        this(new ArrayList<>(), winningNumbers);
    }

    public WinningResult(List<LottoTicket> lottoTickets, List<WinningNumber> winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public List<LottoResult> getTotalLottoResult() {
        final List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            initWinningCountAndBonus();
            lottoResults.add(getLottoResult(lottoTicket));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(LottoTicket lottoTicket) {
        for (WinningNumber winningNumber : winningNumbers) {
            updateWinningCountAndBonus(lottoTicket, winningNumber);
        }

        if(hasToCheckBonus(winningCount)) {
            return LottoResult.from(winningCount, hasBonus);
        }

        return LottoResult.from(winningCount);
    }

    private boolean hasToCheckBonus(int winningCount) {
        return winningCount == 5;
    }

    private void updateWinningCountAndBonus(LottoTicket lotto, WinningNumber winningNumber) {
        if (lotto.getNumbers().contains(winningNumber.getNumber())) {
            winningCount++;
            updateIncludeBonus(winningNumber);
        }
    }

    private void updateIncludeBonus(WinningNumber winningNumber) {
        if (winningNumber.isBonus()) {
            hasBonus = true;
        }
    }

    private void initWinningCountAndBonus() {
        this.winningCount = 0;
        this.hasBonus = false;
    }
}

