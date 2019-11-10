package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(winningLotto);
    }

    @Test
    void checkSix() {
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        lottoResult.add(lotto);

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(1);
    }
}