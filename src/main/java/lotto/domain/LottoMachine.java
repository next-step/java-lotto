package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    public LottoPaper buyLotto(Money money, List<LottoGenerator> lottoGenerators) {

        for (int i = 0; i < money.countOfLottoPurchases() - lottoGenerators.size() ; i++) {
            lottoGenerators.add(new AutoLottoGenerator());
        }

        return new LottoPaper(
                lottoGenerators.stream()
                        .map(LottoGenerator::generateLotto)
                        .collect(Collectors.toList())
        );
    }

}
