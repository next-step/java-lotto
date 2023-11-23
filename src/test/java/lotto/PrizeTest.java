package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @DisplayName("지난주 당첨 번호와 일치하는 개수에 따른 랭크 반환")
    @Test
    void prizeByRank() {
        Lotto lotto = LottoGenerator.generate(Set.of(1, 2, 3, 4, 5, 6));

        Lotto lastWeakLotto = LottoGenerator.generate(Set.of(1, 44, 43, 42, 41, 40));
        WinningLotto winningLotto = WinningLotto.of(lastWeakLotto, LottoNumber.from(45));
        Prize.applyPrize(winningLotto, lotto);

        assertThat(Prize.FIRST.rank().score()).isEqualTo(0);
        assertThat(Prize.SECOND.rank().score()).isEqualTo(0);
        assertThat(Prize.THIRD.rank().score()).isEqualTo(0);
        assertThat(Prize.FOURTH.rank().score()).isEqualTo(0);
        assertThat(Prize.BONUS.rank().score()).isEqualTo(0);
    }

}
