package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoAmountTest {
    @DisplayName("로또 개수 유효성 검사")
    @Test
    void create_lotto_amount() {
        assertThat(new LottoAmount(12).getValue()).isEqualTo(12);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoAmount(-1));
    }
}
