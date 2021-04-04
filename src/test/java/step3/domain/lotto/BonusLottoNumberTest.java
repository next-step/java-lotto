package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoNumberNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("BonusLottoNumber 인스턴스 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증() {
        // given
        LottoNumber nullLottoNumber = null;

        // when and then
        assertThatThrownBy(()-> BonusLottoNumber.valueOf(nullLottoNumber))
                .isInstanceOf(LottoNumberNullPointerException.class)
                .hasMessageContaining("LottoNumber 인스턴스가 null 입니다.");
    }
}