package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @DisplayName("6개의 번호를 제공해야 한다")
    @Test
    void satisfyConstructor() {
        assertThatThrownBy(() -> LotteryNumber.of(1, 2, 2, 3, 4, 5)) //
                .isInstanceOf(NotEnoughNumberException.class);
    }

    @DisplayName("주어진 숫자셋과 교집합의 갯수를 구할 수 있다.")
    @Test
    void intersection() {
        assertThat(LotteryNumber.of(1, 2, 3, 4, 5, 6).getIntersection(LotteryNumber.of(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    static class LotteryNumber {
        public static LotteryNumber of(Integer... numbers) {
            return new LotteryNumber(new HashSet<>(Arrays.asList(numbers)));
        }

        private final Set<Integer> numbers;

        public LotteryNumber(Set<Integer> numbers) {
            this.numbers = Collections.unmodifiableSet(numbers);
            if (numbers.size() != 6) {
                throw new NotEnoughNumberException();
            }
        }

        public Set<Integer> getNumbers() {
            return numbers;
        }

        public int getIntersection(LotteryNumber other) {
            Set<Integer> intersection = new HashSet<>(numbers);
            intersection.retainAll(other.numbers);
            return intersection.size();
        }
    }

    private static class NotEnoughNumberException extends IllegalArgumentException {
    }
}
