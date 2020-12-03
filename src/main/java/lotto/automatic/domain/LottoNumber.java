package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LottoNumber implements Comparable {

    private static final int MAX_LOTTO_NUM = 45;
    private static final int MIN_LOTTO_NUM = 1;
    private static final Map<Integer,LottoNumber> lottoNums = IntStream.rangeClosed(MIN_LOTTO_NUM, MAX_LOTTO_NUM)
            .boxed()
            .collect(toMap(Function.identity(),LottoNumber::new));

    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validate(number);
        return lottoNums.get(number);
    }

    public static List<LottoNumber> random(int amount) {

        List<LottoNumber> nums = new ArrayList(lottoNums.values());
        Collections.shuffle(nums);
        return nums.subList(0, amount);
    }

    private static void validate(int number) {

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
