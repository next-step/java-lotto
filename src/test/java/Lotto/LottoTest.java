package Lotto;

import Lotto.domain.Lotto;
import Lotto.domain.LottoNumbers;
import Lotto.domain.WinningLotto;
import Lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("우승 확인")
    void getWinningType() {
        final Lotto lotto = Lotto.of(LottoNumbers.of(Arrays.asList(1,6,8,10,12,30)));
        final WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1,6,8,10,12,30)));

        assertThat(lotto.getWinningTypeWithWinningNumbers(winningLotto.getWinningNumbers()))
                .isEqualTo(WinningType.FIRST);
    }
}
