package lotto.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

    @Test
    void 로또번호캐싱확인() {
        assertThat(LottoNo.of(3)).isEqualTo(LottoNo.of(3));
    }

    @Test
    void 예외번호입력() {
        assertThatThrownBy(() -> LottoNo.of(47)).isInstanceOf(IllegalArgumentException.class);
    }
}