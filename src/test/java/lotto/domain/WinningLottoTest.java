package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호 생성 성공 테스트")
    void 보너스번호_생성_성공_테스트() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertThat(winningLotto.getWinningLotto().getLottoNumbers().size()).isEqualTo(Lotto.SIZE);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(LottoNumber.valueOf("7"));
    }

    @Test
    @DisplayName("보너스 번호 생성 실패")
    void 보너스번호_생성_실패_테스트_중복번호입력() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6", "6"))
                .isInstanceOf(RuntimeException.class);
    }
}
