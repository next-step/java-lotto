package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static int LOTTO_LENGTH = 6;
    private List<Integer> numbers;

    Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(List.of(num1, num2, num3, num4, num5, num6));
    }

    public Lotto(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 " + LOTTO_LENGTH + "개만 입력 가능합니다");
        }

        this.numbers = new ArrayList<>(numbers);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        List<Integer> printNumbers = new ArrayList<>(numbers);
        Collections.sort(printNumbers);
        for (int number : printNumbers) {
            stringBuilder.append(number).append(", ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 2) + "]\n";
    }
}
