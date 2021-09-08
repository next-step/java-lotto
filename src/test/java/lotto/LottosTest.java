package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("로또 당첨 결과를 올바르게 가져오는지 테스트")
    void result() {
        int amount = 1000;
        Lotto winningLotto = LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        Lottos lottos = new Lottos(Collections.singletonList(winningLotto));
        LottoResult lottoResult = lottos.result(winningNumber, amount);

        assertThat(lottoResult.winningCount(LottoRank.FIRST)).isEqualTo(1);
    }
}