package lotto.domain;

import java.util.Random;

public class LottoNumber {

    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public static LottoNumber makeRandomNumber() {
        Random random = new Random();
        return new LottoNumber(random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
    }
}
