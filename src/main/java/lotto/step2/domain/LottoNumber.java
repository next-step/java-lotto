package lotto.step2.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static String MESSAGE_ILLEGAL_NUMBER = "유효범위를 벗어난 숫자입니다.";
    private final static String MESSAGE_CHECK_NUMERIC = "로또번호는 정수여야 합니다.";
    private final static String NUMERIC_REGEX = "^[-]?[0-9]+$";
    private final static Pattern PATTERN_NUMERIC = Pattern.compile(NUMERIC_REGEX);
    private int number;

    public LottoNumber(String number) {
        this(checkNumeric(number));
    }

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_NUMBER);
        }
        this.number = number;
    }

    private static int checkNumeric(String number){
        if(!PATTERN_NUMERIC.matcher(number).matches()){
            throw new IllegalArgumentException(MESSAGE_CHECK_NUMERIC);
        }
        return Integer.parseInt(number);
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber otherLottoNumber = (LottoNumber) other;
        return number == otherLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

