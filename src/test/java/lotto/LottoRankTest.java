package lotto;

import lotto.domain.LottoRank;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    @DisplayName("로또 일치 개수에 따라서 당첨액이 결정된다.")
    public void lottoPrizeMoneyTest(int matchCount, int prizeMoney) {
        assertThat(LottoRank.of(matchCount, false).getPrizeMoney()).isEqualTo(Money.won(prizeMoney));
    }

    @Test
    @DisplayName("로또 일치 숫자 개수가 0개 이상 6개 이하가 아니면 IllegalArgumentException 이 발생해야 한다. ")
    public void lottoPrizeMoneyExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoRank.of(-1, false));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoRank.of(7, false));
    }

}
