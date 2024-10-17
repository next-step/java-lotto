package lotto;

import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class WinningNumbersTest {
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

    @Test
    void 입력된_당첨번호로부터_생성() {
        // given
        String inputWinningNumbers = "1, 2, 10, 11, 12, 13";
        Set<Integer> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers winningNumbers = WinningNumbers.from(inputWinningNumbers);
        int equalNumberCount = winningNumbers.equalNumberCount(lottoNumbers);

        // then
        Assertions.assertThat(equalNumberCount).isEqualTo(2);
    }
}
