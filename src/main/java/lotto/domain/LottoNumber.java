package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateInputs(number);
        this.number = number;
    }

    public static List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateInputs(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            String messageFormat = "로또 번호는 %d ~ %d 사이 정수만 가능합니다.";
            throw new IllegalArgumentException(String.format(messageFormat, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoNumber that = (LottoNumber) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
