package lotto.domain.lottorank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @DisplayName("당첨 번호 6개를 맞추고, 보너스 번호가 일치하면 1등이다.")
    @Test
    void When_당첨번호_6개_일치_보너스_번호_일치_Then_1등() {
        final LottoRank lottoRank = LottoRank.getRank(6, true);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("당첨 번호 6개를 맞추고, 보너스 번호가 일치하지 않으면 1등 이다.")
    @Test
    void When_당첨번호_6개_일치_보너스_번호_미일치_Then_1등() {
        final LottoRank lottoRank = LottoRank.getRank(6, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("당첨 번호 5개를 맞추고, 보너스 번호가 있으면 2등 이다.")
    @Test
    void When_당첨번호_5개_일치_보너스_번호_일치_Then_2등() {
        final LottoRank lottoRank = LottoRank.getRank(5, true);

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("당첨 번호 5개를 맞추고, 보너스 번호가 없으면 3등 이다.")
    @Test
    void When_당첨번호_5개_일치_보너스_번호_미일치_Then_3등() {
        final LottoRank lottoRank = LottoRank.getRank(5, false);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨 번호 4개를 맞추고, 보너스 번호가 있으면 4등 이다.")
    @Test
    void When_당첨번호_4개_일치_보너스_번호_일치_Then_4등() {
        final LottoRank lottoRank = LottoRank.getRank(4, true);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("당첨 번호 4개를 맞추고, 보너스 번호가 없으면 4등 이다.")
    @Test
    void When_당첨번호_4개_일치_보너스_번호_미일치_Then_4등() {
        final LottoRank lottoRank = LottoRank.getRank(4, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("당첨 번호 3개를 맞추고, 보너스 번호가 있으면 5등 이다.")
    @Test
    void When_당첨번호_3개_일치_보너스_번호_일치_Then_5등() {
        final LottoRank lottoRank = LottoRank.getRank(3, true);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨 번호 3개를 맞추고, 보너스 번호가 없으면 5등 이다.")
    @Test
    void When_당첨번호_3개_일치_보너스_번호_미일치_Then_5등() {
        final LottoRank lottoRank = LottoRank.getRank(3, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨 번호를 2개 이하로 맞추고, 보너스 번호가 있으면 미당첨 이다.")
    @ValueSource(ints = {0, 1, 2})
    @ParameterizedTest
    void When_당첨번호_2개_이하_일치_보너스_번호_일치_Then_미당첨(final int matchCount) {
        final LottoRank lottoRank = LottoRank.getRank(matchCount, true);

        assertThat(lottoRank).isEqualTo(LottoRank.FAIL);
    }

    @DisplayName("당첨 번호를 2개 이하로 맞추고 보너스 번호가 없으면 미당첨 이다.")
    @ValueSource(ints = {0, 1, 2})
    @ParameterizedTest
    void When_당첨번호_2개_이하_일치_보너스_번호_미일치_Then_미당첨(final int matchCount) {
        final LottoRank lottoRank = LottoRank.getRank(matchCount, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FAIL);
    }
}
