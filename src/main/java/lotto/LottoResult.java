package lotto;

import lotto.model.WinningPrice;

import java.util.List;

public class LottoResult {
    private List<LottoPaper> purchasedLottos;
    private LottoNumbers lottoNumbers;

    public LottoResult(List<LottoPaper> purchasedLottos, LottoNumbers lottoNumbers) {
        this.purchasedLottos = purchasedLottos;
        this.lottoNumbers = lottoNumbers;
    }

    public Integer getWinningCount(WinningPrice winningPrice) {
        return Long.valueOf(this.purchasedLottos.stream().filter(lottoPaper ->
                lottoPaper.getWinningPrice(lottoNumbers)
                        .equals(winningPrice))
                .count())
                .intValue();
    }

    public Float getYield() {
        int totalWinningCount = getWinningPrice(WinningPrice.FIRST) +
                getWinningPrice(WinningPrice.SECOND) +
                getWinningPrice(WinningPrice.THIRD) +
                getWinningPrice(WinningPrice.FORTH);
        return (float) totalWinningCount / (purchasedLottos.size() * LottoPaper.LOTTO_PRICE);
    }

    private Integer getWinningPrice(WinningPrice winningPrice) {
        return Long.valueOf(this.purchasedLottos.stream().filter(lottoPaper ->
                lottoPaper.getWinningPrice(lottoNumbers)
                        .equals(winningPrice))
                .count())
                .intValue() * winningPrice.getPrice();
    }
}
