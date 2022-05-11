package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public final static int LOTTO_LENGTH = 6;
    public final static int LOTTO_START_NUMBER = 1;
    public final static int LOTTO_END_NUMBER = 45;
    public final static int LOTTO_PRICE = 1000;

    public enum LOTTO_REWARD {
        MATCH_1(1, 0),
        MATCH_2(2, 0),
        MATCH_3(3, 5_000),
        MATCH_4(4, 50_000),
        MATCH_5(5, 1_500_000),
        MATCH_6(6, 2_000_000_000);

        private final int matches;
        private final long reward;
        LOTTO_REWARD(int mathes, long reward) {
            this.matches = mathes;
            this.reward = reward;
        }
        public static long valueOf(int matches) {
            return Arrays.stream(LOTTO_REWARD.values()).filter(it -> it.matches == matches)
                    .findFirst().get().reward;
        }
    }

    protected Set<Integer> numbers;

    Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(Set.of(num1, num2, num3, num4, num5, num6));
    }

    public Lotto(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 " + LOTTO_LENGTH + "개만 입력 가능합니다");
        }

        this.numbers = new HashSet<>(numbers);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int hasWinningNumbers(Set<Integer> winningNumbers) {
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
