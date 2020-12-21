package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("당첨 번호와 자동 생산된 로또 번호 비교하기")
    void drawAutomaticLotto() {
        Lotto luckyLotto = new Lotto(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(new Integer[]{4, 5, 6, 7, 8, 9});
        Lotto actualLotto = lotto.drawAutomaticLotto(luckyLotto);
        assertThat(actualLotto.getMatchingCount()).isEqualTo(3);
    }

}
