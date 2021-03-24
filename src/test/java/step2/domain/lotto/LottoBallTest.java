package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.exception.CustomException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoBallTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6:6",
            "5:5",
            "42:42"}, delimiter = ':')
    @DisplayName("공을 원하는만큼 만들어낼 수 있다")
    void canGenerateExactQuantityOfBalls(int wanted, int expected) {
        List<LottoBall> lottoBalls = LottoBall.balls(wanted);
        assertThat(lottoBalls.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 55, 142})
    @DisplayName("공을 로또 번호 총 개수보다 많이 만들려고 하면 에러를 던진다")
    void throwsExceptionWhenAskToGenerateInvalidAmount(int wanted) {
        assertThrows(CustomException.class, () -> LottoBall.balls(wanted));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:1,2,3,4,5,6",
            "1,2,3,4,5:1,2,3,4,5"}, delimiter = ':')
    @DisplayName("만들어진 공들이 증가순으로 배열되어있다")
    void generatedBallsAreInAscendingOrder(String balls, String expectedBalls) {
        List<LottoBall> lottoBalls = LottoBall.balls(balls);
        List<LottoBall> expectedLottoBalls = Arrays.stream(expectedBalls.split(","))
                .map(Integer::parseInt)
                .map(LottoBall::new)
                .collect(Collectors.toList());
        for (int idx = 0; idx < lottoBalls.size(); idx++) {
            assertThat(lottoBalls.get(idx)).isEqualTo(expectedLottoBalls.get(idx));
        }
    }

}
