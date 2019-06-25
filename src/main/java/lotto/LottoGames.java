package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGames {

    private List<Lotto> lottos;

    public LottoGames(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public double rateOfReturn(int inputLottoGamePrice) {
        return Math.floor((sumWinnerPrice() / (float) inputLottoGamePrice) * 100) / 100.0;
    }

    public int lottoSummaryWinnerCount(int eventWinnerPrice) {
        return lottos.stream()
                .filter(lotto -> isEventWinnerPrice(lotto, eventWinnerPrice))
                .collect(Collectors.toList()).size();
    }

    private boolean isEventWinnerPrice(Lotto lotto, int eventWinnerPrice) {
        return winnerPrice(lotto) == eventWinnerPrice;
    }

    private int sumWinnerPrice() {
        return lottos.stream().mapToInt(lotto -> winnerPrice(lotto)).sum();
    }

    private int winnerPrice(Lotto lotto) {
        return LottoEnum.findByPrice(
                lotto.getWinnerNumberCount(),
                isBonusWinner(lotto.getBonusNumberCount())
        ).price();
    }

    private boolean isBonusWinner(int bonusNumberCount) {
        return bonusNumberCount > 0;
    }

}
