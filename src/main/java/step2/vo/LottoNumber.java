package step2.vo;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_START_NUMBER = 1;

    private static final int LOTTO_END_NUMBER = 45;

    private final int lottoNumber;

    private static final List<Integer> DEFAULT_LOTTO_NUMBERS;

    static {
        DEFAULT_LOTTO_NUMBERS = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            DEFAULT_LOTTO_NUMBERS.add(number);
        }
    }

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumberRange(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("1~45 사이의 숫자만 허용됩니다.");
        }
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    public static Set<LottoNumber> getSixLottoNumbers() {
        Collections.shuffle(DEFAULT_LOTTO_NUMBERS);
        List<Integer> pickedNumbers = DEFAULT_LOTTO_NUMBERS.subList(0, 6);
        return pickedNumbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber - o.lottoNumber;
    }
}
