package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LotteryNumberTest {
    @DisplayName("6개의 번호를 제공해야 한다")
    @Test
    void satisfyConstructor() {
        Assertions.assertThatThrownBy(() -> new LotteryNumber(new HashSet<>(Arrays.asList(1, 2, 3)))) //
                .isInstanceOf(NotEnoughNumberException.class);
    }

    private static class LotteryNumber {
        public LotteryNumber(Set<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new NotEnoughNumberException();
            }
        }
    }

    private static class NotEnoughNumberException extends IllegalArgumentException {
    }
}
