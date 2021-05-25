package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("숫자의 범위 1-45 밖일 시, IllegalArgumentException 발생")
    @ValueSource(ints = {-4, 0, 46})
    void numberOutOfRangeTest(int value) {

        assertThatThrownBy(() -> {
            new LottoNumber(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("out of range Lotto number");

    }

}
