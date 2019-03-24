package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest
{
    @Test
    public void fiveNumbersMatched() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,7));

        assertThat(winningLotto.match(userLotto)).isEqualTo(5);
    }

    @Test
    public void NoNumbersMatched() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(Arrays.asList(7,8,9,10,11,12));

        assertThat(winningLotto.match(userLotto)).isEqualTo(0);
    }
}
