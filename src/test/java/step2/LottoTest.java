package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("숫자 비교를 통해 일치하는 수의 개수를 확인할 수 있다")
    public void integer_contain() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11));

        assertThat(lotto.countOfWinningNumber(prizeLotto)).isEqualTo(3);
    }

}
