package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberSelectPolicy {

    List<LottoNumber> selectNumbers();

}
