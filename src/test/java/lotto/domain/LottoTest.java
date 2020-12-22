package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("당첨 번호와 자동 생산된 로또 번호 비교하기")
    void drawAutomaticLotto() {
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6});
        LottoNumbers numbers = new LottoNumbers(new Integer[]{4, 5, 6, 7, 8, 9});
        Lotto luckyLotto = new Lotto(luckyNumbers);
        Lotto lotto = new Lotto(numbers);
        lotto.draw(luckyLotto);
        assertThat(lotto.getMatchingCount()).isEqualTo(3);
    }

}
