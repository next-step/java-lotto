package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryNumberTest {

    private static final int MIN_LOTTERY_NUMBER = 1;

    private static final int MAX_LOTTERY_NUMBER = 45;

    @ParameterizedTest(name = "로또 번호 범주 안에 들어가는 번호 입력시 정상 객체가 생성된다 init -> {0}")
    @ValueSource(ints = {MIN_LOTTERY_NUMBER,MAX_LOTTERY_NUMBER})
    void createObjectTest(int source) {
        assertDoesNotThrow(() -> new LotteryNumber(source));
    }

    @ParameterizedTest(name = "로또 번호 범주 밖 번호 입력시 익셉션이 발생한다 init -> {0}")
    @ValueSource(ints = {-1,46})
    void createObjectExceptionTest(int source) {
        assertThatThrownBy(() -> new LotteryNumber(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 의 정수만 입력 될 수 있습니다.");
    }
}