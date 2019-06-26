package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 생성, 값 비교")
    void create() {
        assertThat(LottoNumber.create(1)).isEqualTo(LottoNumber.create(1));
    }

    @Test
    @DisplayName("보너스 번호 생성, 값 비교")
    void create_bonus() {
        assertThat(BonusNumber.create(1)).isEqualTo(BonusNumber.create(1));
    }

    @Test
    @DisplayName("LottoNumber, BonusNumber 비교")
    void equals_lotto_and_bonus() {
        assertThat(BonusNumber.create(1)).isEqualTo(LottoNumber.create(1));
    }

    @Test
    @DisplayName("로또 번호 범위에 벗어나는 경우")
    void invalid_number() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.create(-1));
    }
}
