package lottery.domain;

import static lottery.domain.LotteryNumber.MAX;
import static lottery.domain.LotteryNumber.MIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryNumberTest {

    @ParameterizedTest(name = "로또 번호는 1부터 45까의 수로 생성될 수 있다.  init -> {0}")
    @MethodSource("lotteryNumberProvider")
    void createObjectTest(int source) {
        assertDoesNotThrow(() -> new LotteryNumber(source));
    }

    static Stream<Integer> lotteryNumberProvider() {
        return Stream.of(MIN,
                MAX);
    }

    @ParameterizedTest(name = "로또 번호 1 ~ 45 외의 번호 입력시 익셉션이 발생한다 init -> {0}")
    @ValueSource(ints = {-1,46})
    void createObjectExceptionTest(int source) {
        assertThatThrownBy(() -> new LotteryNumber(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 의 정수만 입력 될 수 있습니다.");
    }

    @ParameterizedTest(name = "로또번호 객체가 배열 안에 포함되어 있을경우 true 를 아닌경우 false 를 리턴한다.")
    @CsvSource(value = {"45:true","1:false"}, delimiter = ':')
    void containsTest(int number, boolean expected) {
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();
        lotteryNumbers.add(new LotteryNumber(MAX));

        assertThat(new LotteryNumber(number).containsNumber(lotteryNumbers))
                .isEqualTo(expected);
    }
}