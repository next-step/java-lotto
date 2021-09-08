package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("로또 당첨 결과를 올바르게 가져오는지 테스트")
    void result() {
        int amount = 1000;
        Lotto winningLotto = new Lotto(Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList()));
        Lottos lottos = new Lottos(Collections.singletonList(winningLotto));
        LottoResult lottoResult = lottos.result(winningLotto, amount);

        assertThat(lottoResult.winningCount(LottoRank.FIRST)).isEqualTo(1);
    }
}