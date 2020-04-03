import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoNumberTest {
    @DisplayName("1~45 범위 안의 숫자가 입력되면 정상적으로 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1,2,45})
    void createTest(int input) {
        assertThatCode(() -> new LottoNumber(input)).doesNotThrowAnyException();
    }
}