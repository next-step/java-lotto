package lotto;

import lotto.model.WinningPrice;

import java.util.List;

public class LottoPaper {
    public static final Integer LOTTO_PRICE = 1000;

    private final LottoNumbers numbers;

    public LottoPaper(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public WinningPrice getWinningPrice(LottoNumbers winningNumbers) {
        int winningCount = numbers.winningCount(winningNumbers);
        return WinningPrice.of(winningCount);
    }

    public List<Integer> getNumberValues() {
        return this.numbers.getNumberValues();
    }
}
