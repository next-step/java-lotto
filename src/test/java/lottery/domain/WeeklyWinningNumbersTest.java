package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeeklyWinningNumbersTest {

    @ParameterizedTest(name = "6개의 중복되지 않은 1~45 숫자를 , 를 기준으로 입력시 정상 객체가 생성된다")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void objCreateTest(String source) {
        assertDoesNotThrow(() -> new WeeklyWinningNumbers(source,7));
    }

    @ParameterizedTest(name = "6개의 수 중 중복된 숫자 또는 6개 이상의 인덱스 가 입력된 경우 예외를 발생한다")
    @ValueSource(strings = {"1,2,2,4,5,6", "1,2,3,4,5,6,7"})
    void objCreateExceptionTest(String source) {
        assertThatThrownBy(() -> new WeeklyWinningNumbers(source,9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 총 6개의 숫자로 구성되어야합니다.");
    }

    @ParameterizedTest(name = "당첨 번호에 대한 초기값 add, remove 와 같은 데이터 조작이 있을경우 예외를 발상한다.")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void unModifiableTest(String source) {
        assertThatThrownBy(() -> new WeeklyWinningNumbers(source,7)
                .getNumbers().add(new LotteryNumber(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest(name = "당첨번호에 보너스 번호가 중복 되었을 경우 예외를 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void invalidBonusTest(String source) {
        assertThatThrownBy(() -> new WeeklyWinningNumbers(source,6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 로또 번호에 포함되어 있습니다.");
    }

    @ParameterizedTest(name = "로또 번호에 보너스 번호가 존재할경우 true 없을 경우 false 를 리턴한다.")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void bonusContainsTest(String source) {
        Lottery lottery = Lottery.lotteryFactory("1,2,3,4,5,45");
        assertAll(
                () -> assertThat(new WeeklyWinningNumbers(source,45)
                        .hasBonusNumber(lottery)).isTrue(),
                () -> assertThat(new WeeklyWinningNumbers(source,23)
                        .hasBonusNumber(lottery)).isFalse()
        );

    }
}
