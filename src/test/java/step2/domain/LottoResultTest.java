package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

    @Test
    void checkSix() {
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        final LottoResult lottoResult = LottoResult.builder()
                                                   .winningLotto(winningLotto)
                                                   .addLotto(lotto)
                                                   .build();

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(1);

        assertThat(lottoResult.winningRate())
                .isEqualTo(1.0 * LottoMatch.SIX.winningReward() / LottoPrice.DEFAULT.price());
    }

    @Test
    void checkThreeMany() {
        final Lotto lottoMatchedThree = new Lotto(1, 2, 3, 11, 12, 13);
        final LottoResult lottoResult = LottoResult.builder()
                                                   .winningLotto(winningLotto)
                                                   .addLotto(lottoMatchedThree)
                                                   .addLotto(lottoMatchedThree)
                                                   .addLotto(lottoMatchedThree)
                                                   .build();

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(3);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(0);

        assertThat(lottoResult.winningRate()).isEqualTo(1.0 * 3 * 5000 / 3000);
    }

    @Test
    void checkThreeOne() {
        final Lotto lottoMatchedThree = new Lotto(1, 2, 3, 11, 12, 13);
        final LottoResult lottoResult = LottoResult.builder()
                                                   .winningLotto(winningLotto)
                                                   .addLotto(lottoMatchedThree)
                                                   .build();

        assertThat(lottoResult.count(LottoMatch.THREE)).isEqualTo(1);
        assertThat(lottoResult.count(LottoMatch.FOUR)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.FIVE)).isEqualTo(0);
        assertThat(lottoResult.count(LottoMatch.SIX)).isEqualTo(0);

        assertThat(lottoResult.winningRate()).isEqualTo(1.0 * 5000 / 1000);
    }
}