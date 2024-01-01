package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

class WinningNumbersTest {

    @Test
    @DisplayName("정확하게 일치하는 번호의 수를 계산하는 확인한다.")
    void test1() {
        WinningNumbers winningNumbers = new WinningNumbers(7, 1, 2, 3, 4, 5, 6);
        LottoNumbers toCompareLottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 7);

        assertThat(winningNumbers.calculateRank(toCompareLottoNumbers)).isEqualTo(Rank.SECOND);
    }
}
