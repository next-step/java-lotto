package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

    @ParameterizedTest(name = "6개의 중복되지 않은 1~45 숫자를 , 를 기준으로 입력시 정상 객체가 생성된다")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void objCreateTest(String source) {
        assertDoesNotThrow(() -> new WinningNumbers(source));
    }

    @ParameterizedTest(name = "6개의 수 중 중복된 숫자 또는 6개 이상의 인덱스 가 입력된 경우 예외를 발생한다")
    @ValueSource(strings = {"1,2,2,4,5,6","1,2,3,4,5,6,7"})
    void objCreateExceptionTest(String source) {
        assertThatThrownBy(() -> new WinningNumbers(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 수는 총 6개로 구성되어야합니다.");
    }

    
}
