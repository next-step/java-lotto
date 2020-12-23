package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    @DisplayName("두 로또 일치하는 숫자 3개")
    void matchNumberCnt_test() {
        Lotto purchasedLotto = Lotto.of(Arrays.asList(1, 3, 7, 11, 34, 43));
        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);

        int matchNumberCnt = winningLotto.matchNumberCnt(purchasedLotto);

        assertThat(matchNumberCnt).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 게임인지 아닌지 ")
    void checkBonus_test() {
        Lotto purchasedLotto = Lotto.of(Arrays.asList(1, 3, 7, 11, 34, 43));
        Lotto winLotto = Lotto.of(Arrays.asList(1, 2, 5, 10, 34, 43));
        LottoNumber bonumsNumber = LottoNumber.of("3");
        WinningLotto winningLotto = new WinningLotto(winLotto, bonumsNumber);

        boolean result = winningLotto.matchBonus(purchasedLotto);

        assertThat(result).isTrue();
    }
}
