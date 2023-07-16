package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 정상적으로 생성한다.")
    void createSuccess() {
        /* given */
        final int value = 7;

        /* when & then */
        assertDoesNotThrow(() -> new LottoNumber(value));
    }

    @ValueSource(ints = {-5, 0, 46})
    @ParameterizedTest
    @DisplayName("허용 범위 밖의 값으로 로또 번호를 생성하면 IllegalArgumentException을 던진다.")
    void createFailWithIllegalArgumentException(final int value) {
        /* given */


        /* when & then */
        assertThatThrownBy(() -> new LottoNumber(value)).isInstanceOf(IllegalArgumentException.class);
    }


}
