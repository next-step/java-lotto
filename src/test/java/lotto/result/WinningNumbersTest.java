package lotto.result;

import lotto.lotto.Lotto;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    @Test
    @DisplayName("로또 등수를 계산한다")
    void shouldReturnCount() {
        Lotto lotto1 = Lotto.from(LottoNumbers.from("1,2,3,4,8,9"));
        Lotto lotto2 = Lotto.from(LottoNumbers.from("1,2,3,4,5,7"));

        WinningNumbers winningNumbers = WinningNumbers.of(LottoNumbers.from("1,2,3,4,5,6"), LottoNumber.from("8"));
        Rank result1 = winningNumbers.result(lotto1);
        Rank result2 = winningNumbers.result(lotto2);

        assertThat(result1).isEqualTo(Rank.SECOND);
        assertThat(result2).isEqualTo(Rank.THIRD);
    }
}