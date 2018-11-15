package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 당첨번호만_맞은_것이_있다() {
        Lotto toWin = Lotto.fromCommaString("1, 2, 3, 4, 5, 6");
        WinningNumber winningNumber = new WinningNumber(toWin, new LottoNumber(10));
        Lotto lotto = new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9));

        assertThat(winningNumber.matched(lotto)).isEqualTo(3);
        assertThat(winningNumber.isBonusMatched(lotto)).isFalse();
    }

    @Test
    public void 당첨번호와_보너스번호_동시에_맞은_것이_있다() {
        Lotto toWin = Lotto.fromCommaString("1, 2, 3, 4, 5, 6");
        WinningNumber winningNumber = new WinningNumber(toWin, new LottoNumber(7));
        Lotto lotto = new Lotto(lottoNumbers(1, 2, 3, 7, 8, 9));

        assertThat(winningNumber.matched(lotto)).isEqualTo(3);
        assertThat(winningNumber.isBonusMatched(lotto)).isTrue();
    }

    private List<LottoNumber> lottoNumbers(Integer... args) {
        return Arrays.stream(args)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
