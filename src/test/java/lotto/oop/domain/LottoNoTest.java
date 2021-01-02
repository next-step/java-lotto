package lotto.oop.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNoTest {
    @Test
    @DisplayName("로또 번호 유효성 체크")
    void invalidCheck() {
        assertThatThrownBy(() -> {
                    new LottoNo(54);
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
