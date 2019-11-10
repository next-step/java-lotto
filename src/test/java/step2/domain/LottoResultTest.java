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

    @Test
    void checkThreeAndFive() {
        final Lotto lottoMatchedThree = new Lotto(1, 2, 3, 11, 12, 13);
        final Lotto lottoMatchedFive = new Lotto(1, 2, 3, 4, 5, 10);
        lottoResult.add(lottoMatchedThree);
        lottoResult.add(lottoMatchedFive);

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(1);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(1);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(0);
    }

    @Test
    void checkThreeMany() {
        final Lotto lottoMatchedThree = new Lotto(1, 2, 3, 11, 12, 13);
        lottoResult.add(lottoMatchedThree);
        lottoResult.add(lottoMatchedThree);
        lottoResult.add(lottoMatchedThree);

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(3);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(0);
    }
}