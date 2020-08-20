package domain;

import strategy.PassivityLottoNumberGenerator;
import strategy.RandomLottoNumberGenerator;
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

    public static Lottos of(int autoCount, int passivityCount, List<String> passivityLottos) {
        return new Lottos(issueLottos(autoCount, passivityCount, passivityLottos));
    }

    private static List<Lotto> issueLottos(int autoCount, int passivityCount, List<String> passivityLottos) {
        return IntStream.range(0, autoCount + passivityCount)
                .mapToObj(i -> i < passivityCount
                        ? Lotto.of(passivityLottos.get(i), new PassivityLottoNumberGenerator())
                        : Lotto.of(new RandomLottoNumberGenerator()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResults getLottoResult(String numbers, int bonusNumber) {
        List<Integer> winningNumbers = SplitUtil.splitToNumber(numbers, DELIMITER);
        ValidateUtil.validateLottoWinningNumber(winningNumbers, bonusNumber);

        LottoResults result = LottoResults.of();
        for (Lotto lotto : lottos) {
            result.win(lotto.hasWinningNumber(winningNumbers), lotto.hasBonusNumber(bonusNumber));
        }

        return result;
    }
}
