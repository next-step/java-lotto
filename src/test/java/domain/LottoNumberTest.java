package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 로또_범위에_해당하지_않는_숫자_입력() {
        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}