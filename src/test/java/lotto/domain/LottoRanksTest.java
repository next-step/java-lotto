package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottorank.LottoRank;
import lotto.domain.lottorank.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRanksTest {

    @DisplayName("로또 등수 리스트를 받아 객체를 생성되고, 로또 등수 리스트를 가지고 있다.")
    @Test
    void Given_로또_등수_리스트_When_객체_생성_Then_로또_등수_리스트를_가짐() {
        // given
        final List<LottoRank> expected = new ArrayList<>();
        expected.add(LottoRank.FIRST);

        // when
        final LottoRanks lottoRanks = new LottoRanks(expected);

        // then
        assertThat(lottoRanks.get()).isEqualTo(expected);
    }
}
