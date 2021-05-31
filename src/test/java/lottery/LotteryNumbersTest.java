package lottery;

import config.ArraySource;
import config.ArraySources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryNumbersTest {

    @Test
    @DisplayName("6개의 로또번호를 가진다.")
    void lotteryNumber_test() {
        LotteryNumbers lotteryNumbers = new LotteryNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @ArraySources(
            {
                    @ArraySource({1, 2, 3, 4, 5, 6, 7}),
                    @ArraySource({1, 2}),
                    @ArraySource({1}),
                    @ArraySource({1, 2, 5})
            }
    )
    @DisplayName("로또번호의 개수가 6개가 아닌 경우 예외처리한다.")
    void notSixDigitLotteryNumber_test(List<Integer> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryNumbers(numbers));
    }

    @ParameterizedTest
    @ArraySources(
            {
                    @ArraySource({1, 1, 3, 4, 5, 6}),
                    @ArraySource({1, 1, 1, 1, 1, 1}),
                    @ArraySource({45, 45, 10, 25, 30, 4})
            }
    )
    @DisplayName("로또번호는 중복되면 안된다.")
    void notDuplicateLotteryNumbers_test(List<Integer> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryNumbers(numbers));
    }
}
