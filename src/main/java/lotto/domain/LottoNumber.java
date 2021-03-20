package lotto.domain;

import java.util.List;

public interface LottoNumber {
    List<Integer> numbers();
    int min();
    int max();
}
