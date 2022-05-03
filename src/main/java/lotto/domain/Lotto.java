package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개만 입력 가능합니다");
        }

        this.numbers = numbers;

        Collections.sort(numbers);
    }

    Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this.numbers.add(num1);
        this.numbers.add(num2);
        this.numbers.add(num3);
        this.numbers.add(num4);
        this.numbers.add(num5);
        this.numbers.add(num6);

        Collections.sort(numbers);
    }

    public int hasWinningNumbers(List<Integer> winningNumbers) {
        int result = 0;
        for (int winningNumber : winningNumbers) {
            result += hasNumber(winningNumber);
        }

        return result;
    }

    private int hasNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return this.numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
