package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningPrizeTest {

    @DisplayName("각 등수별 당첨금을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,false,5000", "4,false,50000", "5,false,1500000", "5,true,30000000", "6,false,2000000000"})
    void winning_price(final int matchNumber, final boolean matchBonus, final BigDecimal price) {

        assertThat(WinningPrize.from(matchNumber, matchBonus).getPrice()).isEqualTo(price);
    }

    @DisplayName("일치하는 번호가 2개 이하는 금액을 받지 못한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0,0", "1,0,0", "2,0,0"})
    void error_winning_price(final int matchNumber, final int countOfMatch) {

        final WinningPrize winningPrize = WinningPrize.from(matchNumber, false);

        assertAll(
                () -> assertThat(winningPrize.getCountOfMatch()).isEqualTo(countOfMatch),
                () -> assertThat(winningPrize.getPrice()).isEqualTo(BigDecimal.ZERO)
        );
    }
}
