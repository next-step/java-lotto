package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 당첨번호와_비교한다() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lotto.match(winningNumber)).isEqualTo(3);
    }
}
