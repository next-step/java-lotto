package lotto.domain;

import java.util.Arrays;
import java.util.List;

public interface LottoNumberStrategy {

    List<Integer> LOTTO_NUMBER_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    List<Integer> createNumber();
}
