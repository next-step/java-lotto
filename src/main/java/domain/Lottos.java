package domain;

import strategy.NumberGenerator;
import study.ValidateUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int buyAmount, NumberGenerator randomNumberGenerator) {
        this.lottos = IntStream.range(0, buyAmount)
                .mapToObj(i -> new Lotto(randomNumberGenerator))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResults getPrizes(List<Integer> winningNumbers) {
        if (!ValidateUtil.valdateWinningNumbers(winningNumbers)) {
            throw new RuntimeException();
        }

        LottoResults prize = new LottoResults();
        for (Lotto lotto : lottos) {
            prize.win(lotto.hasWinningNumber(winningNumbers));
        }

        return prize;
    }
}
