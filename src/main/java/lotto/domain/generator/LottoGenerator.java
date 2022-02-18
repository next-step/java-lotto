package lotto.domain.generator;

import java.util.List;
import lotto.domain.lotto.Number;

public interface LottoGenerator {
    int LOTTO_NUMBERS = 6;
    int START_NUMBER = 1;
    int END_NUMBER = 45;

    List<Number> generateNumbers();
}
