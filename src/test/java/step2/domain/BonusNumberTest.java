package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 숫자 생성 테스트")
    void create() {
        BonusNumber bonusNumber = new BonusNumber(1);

        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호가 아닌 숫자를 입력하면 Exception 발생.")
    void isNotMatchLottoNumber_ShouldException() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}