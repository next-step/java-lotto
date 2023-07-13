package lotto.service;

import lotto.domain.*;
import lotto.util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    public Lottos buyLotto(Money money) {
        long countLotto = money.countLotto();
        List<Lotto> lottos = LongStream.range(0, countLotto)
                .mapToObj(l -> RandomGenerator.generateLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public LottoResults matchWinningLotto(Lottos lottos, WinningLotto winningNumbers) {
        return lottos.matchWinningLotto(winningNumbers);
    }

    public double profitRate(LottoResults lottoResults, Money money) {
        return money.profitRate(lottoResults.sumPrice());
    }
}
