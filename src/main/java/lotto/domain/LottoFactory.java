package lotto.domain;

import java.util.List;

public interface LottoFactory {

    Lotto newInstance();

    Lotto newInstance(List<Integer> numbers);

}
