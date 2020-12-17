package step2.domain.lotto;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;
import static step2.domain.Rank.*;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lotto.addLottoNumber(new LottoNumbers(asList(1, 10, 20, 30, 40, 45)));
        lotto.addLottoNumber(new LottoNumbers(asList(1, 10, 20, 30, 40, 41)));
        lotto.addLottoNumber(new LottoNumbers(asList(1, 10, 20, 30, 39, 41)));
        lotto.addLottoNumber(new LottoNumbers(asList(1, 10, 20, 33, 39, 41)));
        lotto.addLottoNumber(new LottoNumbers(asList(1, 10, 22, 33, 39, 41)));
    }

    @Test
    @DisplayName("로또 당첨 순위 테스트")
    void lottoRankingTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getLottoRanks(target)).containsExactly(FIRST, THIRD, FOURTH, FIFTH, MISS);
    }

    @Test
    @DisplayName("로또 당첨 테스트")
    void winLottoTest() {
        List<Integer> target = asList(1, 10, 20, 30, 40, 45);

        assertThat(lotto.getWinLotto(target))
                .containsKeys(FIRST, THIRD, FOURTH, FIFTH)
                .containsValues(asList(FIRST), asList(THIRD), asList(FOURTH), asList(FIFTH));
    }
}
