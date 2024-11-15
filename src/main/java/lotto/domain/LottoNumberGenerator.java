package lotto.domain;

import java.util.List;

public interface LottoNumberGenerator {

    List<Integer> generate(int min, int max, int size);
}
