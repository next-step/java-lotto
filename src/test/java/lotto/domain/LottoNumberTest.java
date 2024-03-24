package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("생성하는 매개변수가 Bound 범위를 벗어나면 IllegalArgumentException")
    void create() {
        assertAll(
                () -> assertThatNoException().isThrownBy(() -> LottoNumber.valueOf(1)),
                () -> assertThatThrownBy(() -> LottoNumber.valueOf(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> LottoNumber.valueOf(46)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
