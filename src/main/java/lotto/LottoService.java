package lotto;

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

    public LottoResults matchWinningLotto(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.matchWinningNumbers(winningNumbers);
    }

    public double profitRate(LottoResults lottoResults, Money money) {
        return money.profitRate(lottoResults.sumPrice());
    }
}
