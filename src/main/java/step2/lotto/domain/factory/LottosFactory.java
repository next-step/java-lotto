package step2.lotto.domain.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import step2.lotto.domain.Lotto;
import step2.lotto.strategy.LottoNumberGenerator;

public class LottosFactory {

    public static List<Lotto> createLottos(final int lottoGameCount, final LottoNumberGenerator lottoNumberGenerator) {
        return Stream.generate(() -> Lotto.of(lottoNumberGenerator.generateLottoNumbers()))
            .limit(lottoGameCount)
            .collect(Collectors.toList());
    }

}
