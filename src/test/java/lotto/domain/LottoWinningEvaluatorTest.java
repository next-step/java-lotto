package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningEvaluatorTest {
    @Test
    @DisplayName("등수의 대한 당첨개수를 알 수 있다.")
    void shouldReturnWinningCountForEachRank() {
        final List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1), new LottoNumber(13),
            new LottoNumber(27), new LottoNumber(28),
            new LottoNumber(36), new LottoNumber(45)
        );
        final LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator(
            new LottoBundle(List.of(new Lotto(lottoNumbers), new Lotto(lottoNumbers))),
            new Lotto(lottoNumbers)
        );

        final LottoWinningResults results = lottoWinningEvaluator.evaluate();
        assertThat(results.winningCount(LottoRank.first())).isEqualTo(2);
    }

    @Test
    @DisplayName("특정 등수에 당첨된 번호는 다른 등수에 중복당첨 될 수 없다.")
    void shouldNotAllowDuplicateWinsAcrossRanks() {
        final List<LottoNumber> lottoNumbers = List.of(
            new LottoNumber(1), new LottoNumber(13),
            new LottoNumber(27), new LottoNumber(28),
            new LottoNumber(36), new LottoNumber(45)
        );
        final LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator(
            new LottoBundle(List.of(new Lotto(lottoNumbers))),
            new Lotto(lottoNumbers)
        );

        final LottoWinningResults results = lottoWinningEvaluator.evaluate();
        assertThat(results.winningCount(LottoRank.first())).isEqualTo(1);
        assertThat(results.winningCount(LottoRank.third())).isEqualTo(0);
        assertThat(results.winningCount(LottoRank.fourth())).isEqualTo(0);
        assertThat(results.winningCount(LottoRank.fifth())).isEqualTo(0);
    }
}