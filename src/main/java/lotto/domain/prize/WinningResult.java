package lotto.domain.prize;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;
import lotto.ui.ResultView;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<Integer, Integer> winningResult = new HashMap<>();

    private WinningResult(LottoTicket lottoTicket, String enteredWinNumber) {
        makeWinningResult(lottoTicket, enteredWinNumber);
    }

    public static WinningResult create(LottoTicket lottoTicket, String enteredWinNumber) {
        return new WinningResult(lottoTicket, enteredWinNumber);
    }


    private void makeWinningResult(LottoTicket lottoTicket, String enteredWinNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(enteredWinNumber);
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoTicket()) {
            int matchCount = winningNumbers.getMatchCount(lottoNumbers);
            putWinningResult(matchCount);
        }
    }

    private void putWinningResult(int matchCount) {
        if (matchCount > 2) {
            winningResult.put(matchCount, winningResult.getOrDefault(matchCount, 0) + 1);
        }
    }

    private int calculateWinningPrize() {
        int winPrize = 0;
        for (Prize prize : Prize.values()) {
            int winningCount = winningResult.getOrDefault(prize.getMatch(), 0);
            winPrize += prize.calculateTotalPrice(winningCount);
        }
        return winPrize;
    }

    public double calculateWinningRate(double purchaseAmount) {
        double winningPrize = calculateWinningPrize();
        double winningRate = winningPrize / purchaseAmount;
        winningRate = Math.floor(winningRate * 100) / 100.0;
        return winningRate;
    }

    public Map<Integer, Integer> printWinningResult() {
        ResultView.printWinningResult();
        for (Prize prize : Prize.values()) {
            int winningCount = winningResult.getOrDefault(prize.getMatch(), 0);
            ResultView.printWinningResult(prize.getMatch(), prize.getPrice(), winningCount);
        }
        return winningResult;
    }

    public Map<Integer, Integer> getWinningResult() {
        return winningResult;
    }
}
