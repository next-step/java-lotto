package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"5:30000000"}, delimiter = ':')
    @DisplayName("5개 일치에서 보너스 볼이 일치하는 경우 2등에 당첨된다.")
    void bonus(int countMatchNumber, int amount) {
        assertThat(Rank.rank(countMatchNumber, true).getPrice()).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    @DisplayName("당첨 개수의 따라 금액이 달라진다.")
    void decisionMoneyByWinningNumbers(int countMatchNumber, int amount) {
        assertThat(Rank.rank(countMatchNumber, false).getPrice()).isEqualTo(amount);
    }
}
