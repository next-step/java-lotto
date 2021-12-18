package lottery.domain;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("정상 범위(1~45)를 벗어나는 값 테스트")
    void invalidValueTest(final int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LotteryNumber.from(input));
    }
}
