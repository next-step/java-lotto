package Lotto;

import Lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("우승 확인")
    void getWinningType() {
        final Lotto lotto = Lotto.of(LottoNumbers.of(Arrays.asList(1,6,8,10,12,30)));
        final WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(Arrays.asList(1,6,8,10,12,30)), LottoNumber.from(45));

        assertThat(lotto.getWinningTypeWithWinningNumbers(winningLotto))
                .isEqualTo(WinningType.FIRST);
    }
}
