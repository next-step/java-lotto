package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumbers;
import step2.domain.PrizeLotto;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeLottoTest {

    @Test
    @DisplayName("숫자 비교를 통해 일치하는 수의 개수를 확인할 수 있다")
    public void integer_contain() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 9, 10, 11)), 7);

        assertThat(prizeLotto.countOfWinningNumber(lotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 숫자를 맞췄는지 확인할 수 있다")
    public void bonus_matched() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 9, 10, 11)), 7);

        assertThat(prizeLotto.isBonusMatched(lotto)).isTrue();
    }

}
