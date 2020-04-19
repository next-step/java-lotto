package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1 이상 45 이하")
    @Test
    void create() {
        assertThatCode(() -> LottoNumber.of(1)).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumber.of(45)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
    }
}
