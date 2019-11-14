package lotto;

import lotto.domain.LottoProvider;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winnerLotto;
    private List<Integer> winnerNumbers;

    @BeforeEach
    void setUp() {
        winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winnerLotto = LottoProvider.createWinningLotto(winnerNumbers, 7);
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 3, 4, 5, 6))).isEqualTo(LottoRank.FIRST);
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 3, 4, 5, 7))).isEqualTo(LottoRank.SECOND);
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 3, 4, 5, 40))).isEqualTo(LottoRank.THIRD);
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 3, 4, 20, 40))).isEqualTo(LottoRank.FOURTH);
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 3, 12, 20, 40))).isEqualTo(LottoRank.FIFTH);
        assertThat(winnerLotto.matchTo(LottoProvider.createLotto(1, 2, 45, 12, 20, 40))).isEqualTo(LottoRank.NOT_MATCH);
    }

}
