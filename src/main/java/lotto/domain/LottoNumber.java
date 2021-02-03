package lotto.domain;

import lotto.utils.Validator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        validate(this.number);
    }

    public LottoNumber(String number){
        Validator.checkNumberValidation(number);
        this.number = Integer.parseInt(number);
        validate(this.number);
    }

    private void validate(int number){
        Validator.checkLottoNumberValidation(number);
    }

    public static List<LottoNumber> asList(List<Integer> normalNumbers) {
        return normalNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
    public int compareTo(LottoNumber o) {
        if (this.number > o.number) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
