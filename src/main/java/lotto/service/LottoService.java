package lotto.service;

import lotto.domain.*;

import java.util.Map;

public class LottoService {
    private final Lottos lottos = new Lottos();

    public Lottos generateRandomLottos(GenerateNumberStrategy strategy, int totalPrice, int eachPrice) {
        lottos.generateLottosFromStrategy(strategy, totalPrice / eachPrice);
        return lottos;
    }

    public Map<Ranking, Integer> registerWinningNumbers(String numbers, String bonus) {
        Lotto lastWeekWinning = new Lotto(numbers);
        LottoNumber bonusNumber = LottoNumber.createNewNumber(bonus);

        if (lastWeekWinning.hasBonusNumber(bonusNumber))
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복되면 안됩니다.");
        return lottos.countWinningLotto(new Lotto(numbers), LottoNumber.createNewNumber(bonus));
    }
}
