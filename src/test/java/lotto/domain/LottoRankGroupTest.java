package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankGroupTest {
    @Test
    @DisplayName("각 랭크에 맞춰 로또번들 객체를 넣을 수 있다.")
    void shouldAddLottoBundle() {
        final LottoNumbers lottoNumbers = new LottoNumbers();
        final LottoRankGroup group = new LottoRankGroup();

        group.addLotto(LottoRank.first(), new Lotto(lottoNumbers.shuffleAndPickLottoNumbers()));

        assertThat(group.getLottoBundleByRank(LottoRank.first()).size())
            .isEqualTo(1);
    }
}