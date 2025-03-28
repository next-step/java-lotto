package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.util.FixLottoStrategy;
import step2.util.LottoStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.util.LottoNumberUtils.of;

public class LottoStrategyTest {

    @Test
    @DisplayName("random 이 아닌 같은 숫자 반환")
    void fixLottoNums() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(2, 4, 5, 6, 7, 8));
        Lotto lotto = new Lotto(lottoStrategy.generateLottoNumbers());
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(of(2, 4, 5, 6, 7, 8));

    }
}
