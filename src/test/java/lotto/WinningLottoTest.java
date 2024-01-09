package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

class WinningLottoTest {

    @Test
    @DisplayName("정확하게 일치하는 번호의 수를 계산하는 확인한다.")
    void test1() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7));
        Lotto toCompareLotto = new Lotto(1, 2, 3, 4, 5, 7);

        assertThat(winningLotto.calculateRank(toCompareLotto)).isEqualTo(Rank.SECOND);
    }
}
