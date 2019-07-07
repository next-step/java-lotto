package lotto;

import java.util.List;

public interface LottoGenerator {
    int LOTTO_BOUND = 45;
    int LOTTO_NUMBER_MAX_COUNT = 6;

    List<Lotto> generate(Money money);
}