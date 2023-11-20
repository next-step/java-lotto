package step2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosFactory {

    public static List<Lotto> createLottos(final int lottoGameCount, final LottoNumberGenerator lottoNumberGenerator) {
        return Stream.generate(() -> new Lotto(lottoNumberGenerator.generateLottoNumbers()))
            .limit(lottoGameCount)
            .collect(Collectors.toList());
    }

}
