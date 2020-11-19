package lotto.controller;

import lotto.domain.Round;
import lotto.service.LottoService;
import lotto.service.RoundService;

import java.util.Collection;

public class RoundController {
    private final RoundService roundService;
    private final LottoService lottoService;

    public RoundController(RoundService roundService, LottoService lottoService) {
        this.roundService = roundService;
        this.lottoService = lottoService;
    }

    public Round autoBuy(Long budget) {
        Integer price = lottoService.getPrice();
        int pickCount = Math.toIntExact(budget / price.longValue());
        return roundService.autoBuy(pickCount);
    }

    public void checkWinning(Collection<Integer> winningBalls) {
        roundService.checkWinning(winningBalls);
    }
}
