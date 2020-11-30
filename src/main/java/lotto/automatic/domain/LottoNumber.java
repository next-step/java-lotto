package lotto.automatic.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumber implements Comparable {

    private static final int MAX_LOTTO_NUM = 45;
    private static final int MIN_LOTTO_NUM = 1;
    private static final List<LottoNumber> lottoNums = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static List<LottoNumber> random(int amount) {

        Collections.shuffle(lottoNums);
        return lottoNums.subList(0, amount);
    }

    private void validate(int number) {

        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자로 구성되어 있어야 합니다.");
        }
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
        return number;
    }

    @Override
    public int compareTo(Object o) {
        LottoNumber other = (LottoNumber) o;
        return Integer.compare(number, other.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
