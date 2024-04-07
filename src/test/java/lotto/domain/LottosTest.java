package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("당첨 번호 및 보너스 번호 지정 후 내가 뽑은 로또 번호들로 당첨 등급 확인")
    void lottosMatchTest() {

        Lotto winningLottoNumber = Lotto.create(List.of(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, LottoNumber.from(7));

        Lotto selectedLottoNumber = Lotto.create(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos();
        lottos.add(selectedLottoNumber);

        assertThat(lottos.match(winningLotto).getLottoRanks().get(0)).isEqualTo(LottoRank.FIRST);
    }
}