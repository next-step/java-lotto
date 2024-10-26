package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface LottoGenerator {

    int FROM_INDEX = 0;
    int LOTTO_SIZE = 6;

    List<LottoNumber> lottoGenerator = IntStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

    List<Lotto> generateLottos(int purchaseAmount);

}
