package lotto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottos;

    public Lotto() {
        lottos = LottoNumber.getRandomNumber(LOTTO_NUMBER_COUNT);
    }

}
