package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPrizeTest {

    @DisplayName("각 등수별 당첨금을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,false,5000", "4,false,50000", "5,false,1500000", "5,true,30000000", "6,false,2000000000"})
    void winning_price(final int matchNumber, final boolean matchBonus, final BigDecimal price) {

        assertThat(WinningPrize.getWinningPrize(matchNumber, matchBonus).getPrice()).isEqualTo(price);
    }

    @DisplayName("일치하는 번호가 2개 이하는 금액을 받지 못한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 7, 8, 9, 10:2", "1, 7, 8, 9, 10, 11:1", "7, 8, 9, 10, 11, 12:0"}, delimiter = ':')
    void error_winning_price(final String lotto) {

        final Lotto 구매로또 = Lotto.from(lotto);
        final WinningLotto 우승로또 = WinningLotto.from("1, 2, 3, 4, 5, 6", "45");
        final WinningPrize winningPrize = WinningPrize.of(우승로또, 구매로또);

        assertThat(winningPrize.getPrice()).isEqualTo(BigDecimal.ZERO);
    }
}
