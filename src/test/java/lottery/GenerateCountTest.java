package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GenerateCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -20})
    @DisplayName("로또 생성 개수가 1개미만인 경우 예외처리한다.")
    void validateGenerateCount_test(int count) {
        //when
        assertThatIllegalArgumentException().isThrownBy(
                () -> new GenerateCount(count)
        );
    }
}
