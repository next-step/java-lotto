package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoTest {

    @Test
    @DisplayName("로또 개수에 따른 자동 번호 발급 기능")
    void create() {
        assertThatCode(() -> new Lotto(4))
                .doesNotThrowAnyException();
    }
}
