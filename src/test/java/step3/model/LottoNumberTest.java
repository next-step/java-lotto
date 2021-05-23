package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("유효하지 않은 범위의 숫자가 들어 올 경우 IllegalArgumentException 발생 테스트")
    @ValueSource(ints = {0, 46})
    void validationTest(int number) {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> {
                new LottoNumber(number);
            });

        assertThat(exception.getMessage()).isEqualTo("1~45까지의 숫자를 입력하세요");
    }
}
