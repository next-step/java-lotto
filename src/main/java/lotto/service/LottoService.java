package lotto.service;

import lotto.domain.GenerateNumberStrategy;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

import java.util.Map;

public class LottoService {
    private final Lottos lottos = new Lottos();

    public Lottos generateRandomLottos(GenerateNumberStrategy strategy, int totalPrice, int eachPrice) {
        lottos.generateLottosFromStrategy(strategy, totalPrice / eachPrice);
        return lottos;
    }

    public Map<Ranking, Integer> registerWinningNumbers(String numbers) {
        return lottos.countWinningLotto(new Lotto(numbers));
    }
}
