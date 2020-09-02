package step2.domain.lotto;

import step2.domain.lottoResult.LottoResults;
import step2.util.LottoNumberGenerator;
import step2.util.ManualLottoNumberGenerator;
import step2.util.ValidateUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public static Lottos of(int lottoQuantity, int manualLottoCount, List<String> manualLottos) {
        return new Lottos(createLottos(lottoQuantity, manualLottoCount, manualLottos));
    }

    private static List<Lotto> createLottos(int lottoQuantity, int manualLottoCount, List<String> manualLottos) {
        return IntStream.range(0, lottoQuantity + manualLottoCount)
                .mapToObj(i -> i < manualLottoCount
                        ? Lotto.createLottoNumbers(manualLottos.get(i), new ManualLottoNumberGenerator())
                        : Lotto.createLottoNumbers(new LottoNumberGenerator()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResults getLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        ValidateUtil.validate(winningNumbers, bonusNumber);
        LottoResults lottoResults = LottoResults.of();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumbers), lotto.hasBonusNumber(bonusNumber));
        }
        return lottoResults;
    }
}
