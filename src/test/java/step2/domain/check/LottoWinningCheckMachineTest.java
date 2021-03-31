package step2.domain.check;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.exception.LottoNullPointerException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningCheckMachineTest {

    @DisplayName("LottoWinningCheckMachine 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Lotto winningLotto = Lotto.of("1, 2, 3, 4, 5, 6");

        // when
        LottoWinningCheckMachine machine = LottoWinningCheckMachine.of(winningLotto);

        // then
        assertThat(machine).isNotNull();
    }

    @DisplayName("LottoWinningCheckMachine 인스턴스 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증() {
        // given
        Lotto winningLotto = null;

        // when and then
        assertThatThrownBy(() -> LottoWinningCheckMachine.of(winningLotto))
                .isInstanceOf(LottoNullPointerException.class)
                .hasMessageContaining("null 인 Lotto가 입력되었습니다.");

    }

}