package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.constant.LottoRank;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void drawLotsTest() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 45)),
            new Lotto(List.of(1, 2, 3, 4, 44, 45)),
            new Lotto(List.of(1, 2, 3, 43, 44, 45)),
            new Lotto(List.of(1, 2, 42, 43, 44, 45)),
            new Lotto(List.of(1, 41, 42, 43, 44, 45)),
            new Lotto(List.of(40, 41, 42, 43, 44, 45))
        ));
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoRanks expected = new LottoRanks(List.of(LottoRank.FIRST,
            LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH, LottoRank.MISS, LottoRank.MISS,
            LottoRank.MISS));

        assertThat(lottos.drawLots(winningNumber, bonusNumber)).isEqualTo(expected);
    }

}
