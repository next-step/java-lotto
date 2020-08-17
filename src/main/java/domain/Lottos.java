package domain;

import strategy.LottoNumberGenerator;
import study.ValidateUtil;
import util.SplitUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final String DELIMITER = ",";
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int buyAmount, LottoNumberGenerator randomLottoNumberGenerator) {
        List<Lotto> lottos = IntStream.range(0, buyAmount)
                .mapToObj(i -> Lotto.of(randomLottoNumberGenerator))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResults getLottoResult(String numbers, int bonusNumber) {
        List<Integer> winningNumbers = SplitUtil.splitToNumber(numbers, DELIMITER);
        ValidateUtil.validateLottoNumberCount(winningNumbers);

        LottoResults result = LottoResults.of();
        for (Lotto lotto : lottos) {
            result.win(lotto.hasWinningNumber(winningNumbers));
        }

        return result;
    }
}
