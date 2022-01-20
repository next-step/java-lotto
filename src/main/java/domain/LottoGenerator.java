package domain;

import java.util.List;

public interface LottoGenerator {
    int COUNT_LOTTO_NUMBER = 6;
    int START_LOTTO_NUMBER = 1;
    int END_LOTTO_NUMBER = 45;

    List<Integer> generateLottoNumber();
}
