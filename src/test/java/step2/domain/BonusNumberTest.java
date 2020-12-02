package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 숫자 생성 테스트")
    void create() {
        BonusNumber bonusNumber = BonusNumber.getInstance(1);

        assertThat(bonusNumber).isNotNull();
        assertThat(bonusNumber.getNumber()).isEqualTo(1);
    }

    @ParameterizedTest()
    @ValueSource(ints = {-1,0,46,100})
    @DisplayName("로또 당첨 번호가 아닌 숫자를 입력하면 Exception 발생.")
    void isNotMatchLottoNumber_ShouldException(int number) {
        assertThatThrownBy(() -> BonusNumber.getInstance(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}