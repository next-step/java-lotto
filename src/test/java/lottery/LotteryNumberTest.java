package lottery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create_정상(int number) {
        assertThatCode(() -> LotteryNumber.lotteryNumber(number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_비정상(int number) {
        assertThatThrownBy(() -> LotteryNumber.lotteryNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 인스턴스_캐싱(int number) {
        assertThat(LotteryNumber.lotteryNumber(number)).isSameAs(LotteryNumber.lotteryNumber(number));
    }


}
