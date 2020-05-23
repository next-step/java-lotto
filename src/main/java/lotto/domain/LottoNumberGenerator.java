package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount);
}
