package lotto;

import lotto.model.WinningPrice;

import java.util.List;

public class LottoResult {
    private List<LottoPaper> purchasedLottos;
    private WinningNumbers winningNumbers;

    public LottoResult(List<LottoPaper> purchasedLottos, WinningNumbers winningNumbers) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    public Integer getWinningCount(WinningPrice winningPrice) {
        return Long.valueOf(this.purchasedLottos.stream().filter(lottoPaper ->
                lottoPaper.getWinningPrice(winningNumbers)
                        .equals(winningPrice))
                .count())
                .intValue();
    }

    public Float getYield() {
        long totalWinningCount = getWinningPrice(WinningPrice.FIRST) +
                getWinningPrice(WinningPrice.SECOND) +
                getWinningPrice(WinningPrice.THIRD) +
                getWinningPrice(WinningPrice.FORTH);
        return (float) totalWinningCount / (purchasedLottos.size() * LottoPaper.LOTTO_PRICE);
    }

    private long getWinningPrice(WinningPrice winningPrice) {
        return this.purchasedLottos.stream()
                .filter(lottoPaper ->
                        lottoPaper.getWinningPrice(winningNumbers)
                                .equals(winningPrice)
                )
                .count() * winningPrice.getPrice();
    }
}
