package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("1~45 사이 정수가 아닌 경우 IllegalArgumentException throw 한다.")
    @Test
    void createException() {
        assertThatThrownBy(() -> new LottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이 값");
    }
}
