package autolotto.machine.lotto;

import autolotto.machine.winning.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTest {

    @Test
    void 당첨번호와_비교해_일치하는_숫자의_개수를_알려준다() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 23, 24, 25, 21));

        int matchCount = lotto.matchCount(winningNumbers);

        Assertions.assertThat(matchCount).isEqualTo(2);
    }

    @Test
    void 해당_넘버를_갖고_있는지_알려준다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 21, 23, 24, 25));
        int number = 21;

        Assertions.assertThat(lotto.contains(number)).isTrue();
    }
}
