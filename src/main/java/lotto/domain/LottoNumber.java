package lotto.domain;

import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MAX_NUMBER = 45;
    public static final Random RANDOM = new Random();

    private final int number;

    public LottoNumber() {
        number = RANDOM.nextInt(MAX_NUMBER);
    }

    public LottoNumber(String manual) {
        number = Integer.parseInt(manual);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return number - lottoNumber.number;
    }
}
