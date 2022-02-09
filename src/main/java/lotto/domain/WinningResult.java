package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

    private final List<WinningNumber> winningNumbers;
    private final List<LottoTicket> lottoTickets;
    private int matchingCount;
    private boolean hasBonus;

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
        final int BONUS_BALL_MATCHING = 5;
        return winningCount == BONUS_BALL_MATCHING;
    }

    private void updateMatchingCountAndBonus(LottoTicket lottoTicket, WinningNumber winningNumber) {
        if (winningNumber.isBonus() && hasWinningNumber(lottoTicket, winningNumber)) {
            hasBonus = true;
            return;
        }

        if (hasWinningNumber(lottoTicket, winningNumber)) {
            matchingCount++;
        }
    }

    private boolean hasWinningNumber(LottoTicket lottoTicket, WinningNumber winningNumber) {
        return lottoTicket.getNumbers().contains(winningNumber.getNumber());
    }

    private void initMatchingCountAndBonus() {
        this.matchingCount = 0;
        this.hasBonus = false;
    }
}

