package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.exception.LottoNumberNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("WinningLotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);

        // when
        WinningLotto winningLotto = WinningLotto.from(lotto, bonusLottoNumber);

        // then
        assertThat(winningLotto).isNotNull();

    }

    @DisplayName("WinningLotto 인스턴스에 로또에 null 주입시 예이처리 여부 테스트")
    @Test
    void 검증_로또_Null() {
        // given
        Lotto lotto = null;
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);

        // when
        assertThatThrownBy(()-> WinningLotto.from(lotto, bonusLottoNumber))
                .isInstanceOf(LottoNumberNullPointerException.class)
                .hasMessageContaining("LottoNumber 인스턴스가 null 입니다.");

    }

    @DisplayName("WinningLotto 인스턴스 보너스 로또 넘버에 null 주입시 예이처리 여부 테스트")
    @Test
    void 검증_로또넘버_Null() {
        // given
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = null;

        // when
        assertThatThrownBy(()-> WinningLotto.from(lotto, bonusLottoNumber))
                .isInstanceOf(LottoNumberNullPointerException.class)
                .hasMessageContaining("LottoNumber 인스턴스가 null 입니다.");

    }
}