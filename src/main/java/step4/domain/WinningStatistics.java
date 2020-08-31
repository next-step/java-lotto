package step4.domain;

import java.util.List;

public class WinningStatistics {
    private List<Lotto> lottoList;
    private WinningLotto winningLotto;

    public WinningStatistics(List<Lotto> lottoList, WinningLotto winningLotto) {
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
    }

    public boolean isBenefit() {
        return getWinningStatic() > (float) 1;
    }

    public float getWinningStatic() {
        int totalWinningPrice = getTotalWinningPrice();
        if (lottoList.isEmpty()) {
            return 0;
        }
        return (float) totalWinningPrice / (LottoGame.LOTTO_PRICE * lottoList.size());
    }

    public int getTotalWinningPrice() {
        return lottoList.stream()
                .mapToInt(lotto -> WinningPrice.valueOf(winningLotto.winningCount(lotto), winningLotto.matchBonus(lotto)).getPrice())
                .sum();
    }
}
