package step2.domain.lotto;

import step2.domain.lottoResult.LottoResults;
import step2.util.LottoNumberGenerator;
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

    public static Lottos createLottos(int lottoQuantity, LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottos = IntStream.range(0, lottoQuantity)
                .mapToObj(i -> Lotto.createLottoNumbers(lottoNumberGenerator))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResults getLottoResult(List<Integer> winningNumbers) {
        ValidateUtil.validate(winningNumbers);
        LottoResults lottoResults = LottoResults.of();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumbers));
        }
        return lottoResults;
    }
}
