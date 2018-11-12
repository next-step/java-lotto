package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningLottoTest {
    @Test
    public void match() {
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        Rank rank = winningLotto.match(userLotto);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}