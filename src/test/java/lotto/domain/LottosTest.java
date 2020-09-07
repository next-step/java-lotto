package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottos = Lottos.of(Arrays.asList(
                Lotto.of(Arrays.asList(1,2,3,4,5,6)),
                Lotto.of(Arrays.asList(9,10,11,12,13,14))));
        winningLotto = WinningLotto.of(Arrays.asList(4,5,6,7,8,9), 19);
    }

    @DisplayName("로또 개수에 따라 로또 발급 테스트")
    @Test
    void createLottos() {
        Lottos lottos = Lottos.of(3, new LottoNumberRandomGenerator());

        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("로또 번호 당첨 로또 번호와 매칭 확인 테스트")
    @Test
    void match() {
        LottoResult lottoResult = lottos.match(winningLotto);
        assertThat(lottoResult.totalPrizeOfMathRanks()).isEqualTo(5000);
        assertThat(lottoResult.countOfMathRanks(Rank.FIFTH)).isEqualTo(1);
    }
}
