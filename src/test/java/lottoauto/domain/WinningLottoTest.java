package lottoauto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private Lotto lotto;

    @Test
    @DisplayName("당첨 결과 테스트 - 2등")
    void winning_lotto_compare_test2(){
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 13);
        lotto = new Lotto(List.of(1,2,3,4,5,13));
        lotto.match(winningLotto);
        assertThat(lotto.isStatus()).isEqualTo(LottoStatus.SECOND);
    }
}