package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @Test
    @DisplayName("지난 주 당첨 번호를 리스트로 변환한다.")
    void 당첨번호_리스트_변환() {
        String lastWinnerLotto = "1, 2, 3, 4, 5, 6";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winnerLotto = LottoGame.getInstance().getWinnerLotto(lastWinnerLotto);
        assertThat(winnerLotto.getLottoNumbers()).hasSize(6);
        assertThat(winnerLotto).isEqualTo(lotto);
    }


    @Test
    @DisplayName("금액이 1000원 미만이면 exception 발생")
    void 금액_부족() {
        assertThatThrownBy(() -> LottoGame.getInstance().getLottoCount(999))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("해당하는 금액 만큼 구입한 로또 숫자를 반환한다.")
    void 금액을_로또개수로_변환() {
        assertThat(LottoGame.getInstance().getLottoCount(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("구입한 로또 숫자만큼 로또 결과를 반환한다.")
    void 로또개수만큼_결과() {
        assertThat(LottoGame.getInstance().getLottos(14)).hasSize(14);
    }
}
