package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusLottoNumberTest {

    @DisplayName("BonusLottoNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int bonusNumber = 1;

        // when
        BonusLottoNumber bonusLottoNumber = BonusLottoNumber.valueOf(bonusNumber);

        // then
        assertThat(bonusLottoNumber).isNotNull();
    }
}