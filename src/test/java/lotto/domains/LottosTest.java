package lotto.domains;

import lotto.enums.MatchingInfo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 로또_갯수_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(), new Lotto()));
        assertThat(lottos.count()).isEqualTo(2);
    }

    @Test
    void 로또리스트중_n개의숫자가_일치하는_로또카운팅_반환_테스트() {
        LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        Lotto lotto1 = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 45)));
        Lotto lotto2 = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 16)));
        Lottos lottos = new Lottos(Arrays.asList(lotto1,lotto2));

        lottos.matchingWinningNumbersAndBonusNumber(winningLottoNumbers, bonusNumber);
        assertThat(lottos.countOfMatchingNumber(MatchingInfo.MATCH_FIVE_AND_BONUS)).isEqualTo(1);
        assertThat(lottos.countOfMatchingNumber(MatchingInfo.MATCH_FIVE)).isEqualTo(1);
    }
}
