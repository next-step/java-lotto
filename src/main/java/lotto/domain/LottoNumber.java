package lotto.domain;

import lotto.dto.LottoNumberDTO;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int NUM_LEFT_BOUND = 1;
    public static final int NUM_RIGHT_BOUND = 45;

    private Integer number;

    public LottoNumber(String string) {
        int number = Integer.parseInt(string);
        checkBounds(number);
        this.number = number;
    }

    public LottoNumber(int number) {
        checkBounds(number);
        this.number = number;
    }

    private void checkBounds(int number) {
        if (number < NUM_LEFT_BOUND || number > NUM_RIGHT_BOUND) {
            throw new RuntimeException();
        }
    }

    public LottoNumberDTO getLottoNumberDTO() {
        return new LottoNumberDTO(number);
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
    public int compareTo(LottoNumber other) {
        return number.compareTo(other.number);
    }
}
