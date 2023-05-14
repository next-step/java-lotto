package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

    @Test
    void 로또번호캐싱확인() {
        assertAll(
                () -> assertThat(LottoNo.of(3)).isEqualTo(LottoNo.of(3)),
                () -> assertThat(LottoNo.of(47)).isEqualTo(LottoNo.of(47))
                );
    }
}