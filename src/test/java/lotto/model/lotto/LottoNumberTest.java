package lotto.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @DisplayName("같은 번호를 인자로 받아 생성된 LottoNumber 객체는 같은 객체이다.")
    @Test
    void createTest() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("LottoNumber의 인자로 들어오는 숫자가 1보다 작거나, 45보다 크면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateRangeTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(input);
        });
    }
}
