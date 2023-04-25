package lotto.model.sample;

import lotto.model.Lotto;

public class LottoSample {
    public static final Lotto CRITERIA = Lotto.of(1, 2, 3, 4, 5, 6);
    public static final Lotto FIRST = Lotto.of(1, 2, 3, 4, 5, 6);
    public static final Lotto SECOND = Lotto.of(1, 2, 3, 4, 5, 7);
    public static final Lotto THIRD = Lotto.of(1, 2, 3, 4, 7, 8);
    public static final Lotto FOURTH = Lotto.of(1, 2, 3, 7, 8, 9);
    public static final Lotto NONE = Lotto.of(7, 8, 9, 10, 11, 12);

    private LottoSample() {
    }

}
