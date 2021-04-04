package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;

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
}