package lotto.service;

import lotto.domain.*;

public class LottoService {
    private final Lottos lottos = new Lottos();

    public Lottos generateRandomLottos(GenerateNumberStrategy strategy, int totalPrice, int eachPrice) {
        lottos.generateLottosFromStrategy(strategy, totalPrice / eachPrice);
        return lottos;
    }

    public RankingResult registerWinningNumbers(String numbers, String bonus) {
        Lotto lastWeekWinning = new Lotto(numbers);
        LottoNumber bonusNumber = LottoNumber.createNewNumber(bonus);

        return new RankingResult(lottos.countWinningLotto(new WinningLotto(lastWeekWinning, bonusNumber)));
    }
}
