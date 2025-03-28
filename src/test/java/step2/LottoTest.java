package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNum;
import step2.domain.Winning;
import step2.util.FixLottoStrategy;
import step2.util.LottoNumberUtils;
import step2.util.LottoStrategy;
import step2.domain.Rank;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.util.LottoNumberUtils.of;

class LottoTest {
    @Test
    @DisplayName("6개 보다 많은 숫자")
    void upTo6() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(2, 4, 5, 6, 7, 8, 9));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoStrategy.generateLottoNumbers()));
    }

    @Test
    @DisplayName("6개 보다 적은 숫자")
    void downTo6() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(2, 4, 9));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(lottoStrategy.generateLottoNumbers()));
    }

    @Test
    @DisplayName("5개 + 보너스 번호가 다른 경우 2등을 리턴한다")
    void notMatchedBonus() {
        Lotto lotto = new Lotto(LottoNumberUtils.of(2, 3, 4, 5, 6, 9));
        Set<LottoNum> winningNums = LottoNumberUtils.of(1, 2, 3, 4, 5, 6);
        Winning winning = new Winning(winningNums, new LottoNum(19));

        assertThat(winning.match(lotto).getRank()).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 + 보너스 번호가 같은 경우 2등_bonus을 리턴한다")
    void matchedBonus() {
        Lotto lotto = new Lotto(LottoNumberUtils.of(2, 4, 5, 6, 3, 19));
        Set<LottoNum> winningNums = LottoNumberUtils.of(1, 2, 3, 4, 5, 6);
        Winning winning = new Winning(winningNums, new LottoNum(19));

        assertThat(winning.match(lotto).getRank()).isEqualTo(Rank.SECOND);
    }
}
