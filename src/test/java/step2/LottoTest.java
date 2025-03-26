package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNum;
import step2.util.FixLottoStrategy;
import step2.util.LottoStrategy;

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
    @DisplayName("로또번호와 당첨번호가 5개 같은 경우")
    void countMatch() {
        Lotto lotto = new Lotto(of(2, 4, 5, 6, 3, 9));
        Set<LottoNum> winningNums = of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.countMatch(winningNums)).isEqualTo(5);
    }
}
