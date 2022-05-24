package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {
    private final Lottos lottos = new Lottos();

    public Lottos generateRandomLottos(GenerateNumberStrategy strategy, Money randomPurchaseMoney) {
        lottos.generateLottosFromStrategy(strategy, randomPurchaseMoney.purchaseCount());
        return lottos;
    }

    public Lottos generateManualLottos(List<String> lottoList) {
        lottoList.forEach(lottos::generateLottoFromUserInput);
        return lottos;
    }

    public RankingResult registerWinningNumbers(String numbers, String bonus) {
        Lotto lastWeekWinning = new Lotto(numbers);
        LottoNumber bonusNumber = LottoNumber.createNewNumber(bonus);

        return new RankingResult(lottos.countWinningLotto(new WinningLotto(lastWeekWinning, bonusNumber)));
    }
}
