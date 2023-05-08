package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 1장 생성 테스트")
    void createLotto() {
        final int LOTTO_NUMBER_COUNT = 6;
        Lotto lotto = new Lotto();
        Assertions.assertThat(lotto.getLottoNumber()).hasSize(LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("로또와 당첨번호를 비교하여 몇개가 일치하는지 테스트")
    void getNumberOfMatchesInLottoTest() {
        int[] winnerNumbers = {2, 10, 15, 20, 23, 40};
        Lotto lotto = new Lotto(new int[]{2, 10, 15, 20, 23, 45});
        Assertions.assertThat(lotto.getNumberOfMatchesInLotto(winnerNumbers)).isEqualTo(5);
    }
}
