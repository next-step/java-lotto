package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryNumbersTest {

    @Test
    @DisplayName("로또 번호 가운데 중복된 것이 있으면 예외를 던진다.")
    void throwExceptionIfNumbersDuplicated() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36, 36);

        assertThatThrownBy(() -> new LotteryNumbers(numbers)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외를 던진다.")
    void throwExceptionIfLotteryNumberIsInsufficient() {
        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36);

        assertThatThrownBy(() -> new LotteryNumbers(numbers)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 목록에서 특정 로또 번호가 있는지 알아낸다.")
    @ParameterizedTest
    @CsvSource({"7,true", "42,true", "45,false"})
    void containsLotteryNumber(int number, boolean expected) {
        LotteryNumber lotteryNumber = new LotteryNumber(number);

        List<Integer> numbers = Arrays.asList(1, 7, 10, 23, 36, 42);
        LotteryNumbers lotteryNumbers = new LotteryNumbers(numbers);

        assertThat(lotteryNumbers.contains(lotteryNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("두 로또 번호를 비교해서 일치하는 개수를 반환한다.")
    void countMatchedNumbers() {
        List<Integer> numbers1 = Arrays.asList(1, 7, 10, 23, 36, 42);
        List<Integer> numbers2 = Arrays.asList(1, 7, 11, 26, 33, 42);

        LotteryNumbers lotteryNumbers1 = new LotteryNumbers(numbers1);
        LotteryNumbers lotteryNumbers2 = new LotteryNumbers(numbers2);

        assertThat(lotteryNumbers1.countMatchedNumbers(lotteryNumbers2)).isEqualTo(3);
    }
}
