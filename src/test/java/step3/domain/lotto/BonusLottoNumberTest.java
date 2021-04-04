package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoNumberNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> BonusLottoNumber.valueOf(nullLottoNumber))
                .isInstanceOf(LottoNumberNullPointerException.class)
                .hasMessageContaining("LottoNumber 인스턴스가 null 입니다.");
    }

    @DisplayName("BonusLottoNumber 인스턴스가 로또에 포함되었는지에 대한 여부 테스트")
    @Test
    void 검증_로또_포함되었는지() {
        // given
        LottoNumber lottoNumber = LottoNumber.valueOf(1);
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");

        // when
        BonusLottoNumber bonusLottoNumber = BonusLottoNumber.valueOf(lottoNumber);
        boolean actual = bonusLottoNumber.isIncludeByLotto(lotto);

        assertThat(actual).isTrue();
    }
}