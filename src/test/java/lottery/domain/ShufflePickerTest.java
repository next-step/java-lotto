package lottery.domain;

import lottery.domain.strategy.ShufflePicker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ShufflePickerTest {
    @DisplayName("shuffle시 count만큼 뽑는지 검사")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void pick_count(int count) {
        assertThat(new ShufflePicker().pick(count).size()).isEqualTo(count);
    }

    @DisplayName("shuffle 값이 범위 내에 있는지 검사")
    @RepeatedTest(20)
    void pick() {
        new ShufflePicker().pick(Lottery.COUNT_LOTTERY_NUMBER).stream().forEach(l ->
                assertThat(l).isBetween(LotteryNumber.valueOf(LotteryNumber.MIN), LotteryNumber.valueOf(LotteryNumber.MAX))
        );
    }
}
