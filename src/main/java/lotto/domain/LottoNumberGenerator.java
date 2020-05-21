package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Integer> generateLottoNumber(List<Integer> lottoNumbers, int lottoCount);
}
