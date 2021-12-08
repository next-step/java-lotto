package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private final List<Integer> lottoNumber;

    private LottoNumber(List<Integer> lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of() {
        List<Integer> numbers = ShuffleNumber.shuffle(START_NUMBER, END_NUMBER);
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumber.add(numbers.get(i));
        }
        Collections.sort(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber of(List<Integer> lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public int compareTo(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : winningNumbers) {
            count = plusWinningCount(count, number);
        }
        return count;
    }

    public List<Integer> lottoNumber() {
        return lottoNumber;
    }

    private int plusWinningCount(int count, int winningNumber) {
        if (has(winningNumber)) count++;
        return count;
    }

    private boolean has(int winningNumber) {
        return lottoNumber.contains(winningNumber);
    }

    private void validate(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
