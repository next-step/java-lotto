package lotto.domain;

import java.util.*;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    private LottoNumber(int i) {
        this.number = validate(i);
    }
    public static LottoNumber valueOf(int number){
        if(number>=MIN_NUMBER&&number<=MAX_NUMBER){
            return CACHE.get(number);
        }
        return new LottoNumber(number);
    }

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            CACHE.put(number, new LottoNumber(number));
        }
    }


    private int validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1-45 사이로 입력해야 합니다");
        }
        return number;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
