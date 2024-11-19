package lotto.domain;

import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final LottoNumber[] CACHE;

    static {
        CACHE = IntStream.rangeClosed(MIN, MAX)
                .mapToObj(LottoNumber::new)
                .toArray(LottoNumber[]::new);
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        try {
            return CACHE[number - 1];

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
        }
    }

    public static LottoNumber valueOf(String number) {
        try {
            return valueOf(Integer.parseInt(number));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 사용할 수 있습니다.");
        }
    }

    public static LottoNumber bonusLottoNumberOf(String number, LottoNumbers winner) {
        LottoNumber bonusLottoNumber = valueOf(Integer.parseInt(number));
        if (winner.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 포함될 수 없습니다.");
        }

        return bonusLottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber that) {
        return this.number - that.number;
    }
}

