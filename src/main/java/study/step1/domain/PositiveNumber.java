package study.step1.domain;

import java.util.Objects;

public class PositiveNumber {
    private int number = 0;

    public PositiveNumber(String number) {
        int parseNumber = this.parseInt(number);
        this.validPasitive(parseNumber);
        this.number = parseNumber;
    }

    private int parseInt(String number) {
        int parseNumber = 0;
        try {
            parseNumber = Integer.parseInt(number);
        } catch(RuntimeException e) {
            throw new RuntimeException("잘못된 입력값입니다.");
        }
        return parseNumber;
    }

    private void validPasitive(int number) {
        if(number < 0) {
            throw new RuntimeException("잘못된 입력값입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PositiveNumber that = (PositiveNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
