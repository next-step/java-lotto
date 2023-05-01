package lottery.domain;

import static lottery.domain.constant.LotteryNumberRule.MAX_LOTTERY_NUMBER;
import static lottery.domain.constant.LotteryNumberRule.MIN_LOTTERY_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryNumberTest {

    @ParameterizedTest(name = "로또 번호 범주 안에 들어가는 번호 입력시 정상 객체가 생성된다 init -> {0}")
    @MethodSource("lotteryNumberProvider")
    void createObjectTest(int source) {
        assertDoesNotThrow(() -> new LotteryNumber(source));
    }

    static Stream<Integer> lotteryNumberProvider() {
        return Stream.of(MIN_LOTTERY_NUMBER.getRuleNumber(),
                MAX_LOTTERY_NUMBER.getRuleNumber());
    }

    @ParameterizedTest(name = "로또 번호 범주 밖 번호 입력시 익셉션이 발생한다 init -> {0}")
    @ValueSource(ints = {-1,46})
    void createObjectExceptionTest(int source) {
        assertThatThrownBy(() -> new LotteryNumber(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 의 정수만 입력 될 수 있습니다.");
    }
}