package dev.solar.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int value;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    public static List<LottoNumber> random(int size) {

        final List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        final ArrayList<Integer> keys = new ArrayList<>(lottoNumbers.keySet());
        Collections.shuffle(keys);
        for (final Integer key : keys) {
            randomLottoNumbers.add(lottoNumbers.get(key));
        }
        return randomLottoNumbers.subList(0, size);
    }

    public static LottoNumber of(final int number) {
        final LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 번호 범위는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 입니다.");
        }
        return lottoNumber;
    }

    public static LottoNumber of(final String number) {
        return of(toNumber(number));
    }

    private static int toNumber(final String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }

        return Integer.parseInt(number);
    }

    private static boolean isNumber(final String input) {
        String regExp = "^[0-9]+$";

        return input.matches(regExp);
    }

    public void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호 범위는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 입니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
               "value=" + value +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(value, o.value);
    }
}
