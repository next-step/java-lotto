package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨번호를 입력으로 넣으면 당첨금 2_000_000_000원이다.")
    void winningLottoTest() {
        // given
        Lotto winningNumbersLotto = new Lotto(List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));

        Lottos lottos = new Lottos();
        lottos.addLotto(winningNumbersLotto);
        WinningInfos winningInfos = new WinningLotto(winningNumbersLotto).winningInfos(lottos);

        assertThat(winningInfos.earningMoney()).isEqualTo(2_000_000_000);
    }
}
