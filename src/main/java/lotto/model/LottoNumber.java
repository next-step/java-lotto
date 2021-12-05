package lotto.model;

import java.util.Random;

public class LottoNumber {
    private static final Random RANDOM = new Random();
    private final int number;

    public LottoNumber() {
        this(RANDOM.nextInt(45) + 1);
    }
    public LottoNumber(int number) {
        this.number = number;
    }
}
