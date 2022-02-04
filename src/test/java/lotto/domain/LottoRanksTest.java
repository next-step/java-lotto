package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRanksTest {

    @DisplayName("생성 확인")
    @Test
    void 생성_확인() {
        // given
        final List<LottoRank> expected = new ArrayList<>();
        expected.add(LottoRank.FIRST);

        // when
        final LottoRanks lottoRanks = new LottoRanks(expected);

        // then
        assertThat(lottoRanks.get()).isEqualTo(expected);
    }
}
