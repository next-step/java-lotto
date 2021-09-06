package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("로또 당첨 결과를 올바르게 가져오는지 테스트")
    void result() {
        int amount = 1000;
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(winningNumbers)));
        LottoResult lottoResult = lottos.result(winningNumbers, amount);

        assertThat(lottoResult.winningCount(LottoRank.FIRST)).isEqualTo(1);
    }
}