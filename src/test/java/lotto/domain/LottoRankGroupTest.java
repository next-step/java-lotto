package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankGroupTest {
    @Test
    @DisplayName("각 랭크에 맞춰 로또번들 객체를 넣을 수 있다.")
    void shouldAddLottoBundle() {
        final LottoRankGroup group = new LottoRankGroup();

        group.addLotto(LottoRank.FIRST, new Lotto(LottoNumber.getNewLottoNumbers(LOTTO_NUMBER_COUNT)));

        assertThat(group.getLottoBundleByRank(LottoRank.FIRST)).hasSize(1);
    }
}