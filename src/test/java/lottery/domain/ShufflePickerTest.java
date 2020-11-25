package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.*;

public class ShufflePickerTest {
    @DisplayName("shuffle 값이 범위 내에 있는지 검사")
    @RepeatedTest(20)
    void pick() {
        new ShufflePicker().pick().stream().forEach(l ->
                assertThat(l).isBetween(LotteryNumber.valueOf(LotteryNumber.MIN), LotteryNumber.valueOf(LotteryNumber.MAX))
        );
    }
}
