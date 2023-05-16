package lotto;

import java.math.BigDecimal;
import java.util.List;

public class Lotto {
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static final int SIZE = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.numbers = numbers;
    }


    public int getMatchCount(List<Integer> numbers) {
        int matchCount = 0;
        for (int num : numbers) {
            matchCount = plusMatchCount(matchCount, num);
        }
        return matchCount;
    }


    private int plusMatchCount(int matchCount, int num) {
        if (hasNumber(num)) matchCount++;
        return matchCount;
    }

    public String getNumbersString() {
        return numbers.toString();
    }

    public boolean hasNumber(int num) {
        return numbers.contains(num);
    }
}
