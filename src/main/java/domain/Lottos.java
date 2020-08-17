package domain;

import strategy.LottoNumberGenerator;
import study.ValidateUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int buyAmount, LottoNumberGenerator randomLottoNumberGenerator) {
        return new Lottos(IntStream.range(0, buyAmount)
                .mapToObj(i -> Lotto.of(randomLottoNumberGenerator))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResults getLottoResult(List<Integer> winningNumbers) {
        if (!ValidateUtil.valdateWinningNumbers(winningNumbers)) {
            throw new RuntimeException();
        }

        LottoResults result = LottoResults.of();
        for (Lotto lotto : lottos) {
            result.win(lotto.hasWinningNumber(winningNumbers));
        }

        return result;
    }
}
