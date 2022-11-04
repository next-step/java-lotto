package lottery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create_정상(int lotteryNumber) {
        assertThatCode(() -> LotteryNumber.lotteryNumber(lotteryNumber)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_비정상(int lotteryNumber) {
        assertThatThrownBy(() -> LotteryNumber.lotteryNumber(lotteryNumber)).isInstanceOf(IllegalArgumentException.class);
    }


}
