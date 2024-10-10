package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class WinningNumbersTest {
    @Test
    void 당첨번호와_일치하는_번호_개수_구하기() {
        // given
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(Set.of(1, 2, 10, 11, 12, 13));

        // when
        int equalNumberCount = winningNumbers.equalNumberCount(lottoNumbers);

        // then
        Assertions.assertThat(equalNumberCount).isEqualTo(2);
    }
}
