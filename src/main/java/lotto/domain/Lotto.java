package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.NumberGenerator;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoList;

    public Lotto() {
        this.lottoList = NumberGenerator.of(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE)
            .getNumberList();
    }

    public List<Integer> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

}
