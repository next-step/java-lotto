package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void matches() {
        final int bonusNumber = 6;
        Lotto lottoWithWinningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);

        Lotto lotto = new Lotto(Arrays.asList(1,3,5,7,9,11));

        Prize prize = winningLotto.matches(lotto);
        assertThat(prize).isEqualTo(Prize.FIFTH);

    }
}
