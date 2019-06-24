package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGames {

    private static final int LOTTO_ONE_GAME_PRICE = 1000;
    private List<Lotto> lottos;

    public LottoGames(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public double rateOfReturn() {
        return Math.floor((sumWinnerPrice() / (float) sumLottoGamesPurchasePrice()) * 100) / 100.0;
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
        return LottoEnum.findByPrice(lotto.getWinnerNumberCount()).price();
    }

    private int sumLottoGamesPurchasePrice() {
        return LOTTO_ONE_GAME_PRICE * lottos.size();
    }

}
