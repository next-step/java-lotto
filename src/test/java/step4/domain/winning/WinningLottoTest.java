package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import step4.exception.LottoNullPointerException;
import step4.exception.LottoNumberNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("WinningLotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String StringWinningLotto = "1, 2, 3, 4, 5, 6";
        int bonusLottoNumber = 7;

        // when
        WinningLotto winningLotto = WinningLotto.from(StringWinningLotto, bonusLottoNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("WinningLotto 인스턴스에 Null인 Lotto 주입시 예외처리 여부 테스트")
    @Test
    void 검증_Lotto_Null() {
        // given
        Lotto lotto = null;
        LottoNumber lottoNumber = LottoNumber.valueOf(7);

        // when
        assertThatThrownBy(()-> WinningLotto.from(lotto, lottoNumber))
                .isInstanceOf(LottoNullPointerException.class)
                .hasMessageContaining("Lotto 인스턴스가 null 입니다.");

    }

    @DisplayName("WinningLotto 인스턴스에 Null인 LottoNumber 주입시 예외처리 여부 테스트")
    @Test
    void 검증_LottoNumber_Null() {
        // given
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        LottoNumber lottoNumber = null;

        // when
        assertThatThrownBy(()-> WinningLotto.from(lotto, lottoNumber))
                .isInstanceOf(LottoNumberNullPointerException.class)
                .hasMessageContaining("LottoNumber 인스턴스가 null 입니다.");

    }

}