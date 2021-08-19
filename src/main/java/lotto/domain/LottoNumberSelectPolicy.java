package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberSelectPolicy {

    List<Integer> selectNumbers();

}
