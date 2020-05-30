package lotto.generator;

import lotto.domain.Lotto;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount);
}
