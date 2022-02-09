package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;

public class WinningResult {

    private final List<WinningNumber> winningNumbers;
    private final List<LottoTicket> lottoNumbers;
    private int count;
    private boolean includeBonus;

    public WinningResult(List<WinningNumber> winningNumbers) {
        this(new ArrayList<>(), winningNumbers);
    }

    public WinningResult(List<LottoTicket> lottoNumbers, List<WinningNumber> winningNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
    }

    public List<LottoResult> getTotalLottoResult() {
        final List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoTicket lotto : lottoNumbers) {
            initWinningCountAndBonus();
            lottoResults.add(getLottoResult(lotto));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(LottoTicket lotto) {
        for (WinningNumber winningNumber : winningNumbers) {
            updateWinningCountAndBonus(lotto, winningNumber);
        }

        if(hasToCheckBonus(count)) {
            return LottoResult.from(count, includeBonus);
        }

        return LottoResult.from(count);
    }

    private boolean hasToCheckBonus(int count) {
        return count == 5;
    }

    private void updateWinningCountAndBonus(LottoTicket lotto, WinningNumber winningNumber) {
        if (lotto.getNumbers().contains(winningNumber.getNumber())) {
            count++;
            updateIncludeBonus(winningNumber);
        }
    }

    private void updateIncludeBonus(WinningNumber winningNumber) {
        if (winningNumber.isBonus()) {
            includeBonus = true;
        }
    }

    private void initWinningCountAndBonus() {
        this.count = 0;
        this.includeBonus = false;
    }
}

