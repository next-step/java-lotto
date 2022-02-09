package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private final List<WinningNumber> winningNumbers;
    private final List<LottoTicket> lottoTickets;
    private int matchingCount;
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
            initMatchingCountAndBonus();
            lottoResults.add(getLottoResult(lottoTicket));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(LottoTicket lottoTicket) {
        for (WinningNumber winningNumber : winningNumbers) {
            updateMatchingCountAndBonus(lottoTicket, winningNumber);
        }

        if (hasToCheckBonus(matchingCount)) {
            return LottoResult.from(matchingCount, hasBonus);
        }

        return LottoResult.from(matchingCount);
    }

    private boolean hasToCheckBonus(int winningCount) {
        return winningCount == 5;
    }

    private void updateMatchingCountAndBonus(LottoTicket lotto, WinningNumber winningNumber) {
        if (lotto.getNumbers().contains(winningNumber.getNumber())) {
            matchingCount++;
            updateHasBonus(winningNumber);
        }
    }

    private void updateHasBonus(WinningNumber winningNumber) {
        if (winningNumber.isBonus()) {
            hasBonus = true;
        }
    }

    private void initMatchingCountAndBonus() {
        this.matchingCount = 0;
        this.hasBonus = false;
    }
}

