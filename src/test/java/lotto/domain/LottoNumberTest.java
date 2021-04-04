package lotto.domain;

import lotto.constant.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호로 46이상 번호를 입력하면 오류발생")
    void createLottoNumberTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(47))
                .withMessage(LottoError.LOTTO_NUMBER_OVER_EXCEPTION);
    }

    @Test
    @DisplayName("보너스 번호와 일치하면 true 아니면 false")
    void isMatchBonusTest() {
        LottoNumber bonusLottoNumber = new LottoNumber(5);

        assertThat(new LottoNumber(5).isMatchBonus(bonusLottoNumber)).isTrue();
        assertThat(new LottoNumber(6).isMatchBonus(bonusLottoNumber)).isFalse();
    }
}
