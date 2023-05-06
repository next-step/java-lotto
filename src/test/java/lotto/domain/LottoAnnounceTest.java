package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.constant.LottoRank;
import org.junit.jupiter.api.Test;

class LottoAnnounceTest {

    @Test
    void createRanksTest() {
        LottoAnnounce lottoAnnounce = new LottoAnnounce(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 45)),
            new Lotto(List.of(1, 2, 3, 4, 44, 45)),
            new Lotto(List.of(1, 2, 3, 43, 44, 45)),
            new Lotto(List.of(1, 2, 42, 43, 44, 45)),
            new Lotto(List.of(1, 41, 42, 43, 44, 45)),
            new Lotto(List.of(40, 41, 42, 43, 44, 45))
        );

        assertThat(lottoAnnounce.createRanks(lottos).getLottoRanks()).containsExactly(LottoRank.FIRST,
            LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.MISS, LottoRank.MISS,
            LottoRank.MISS);
    }

}