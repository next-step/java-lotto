package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @DisplayName("당첨 번호 갯수와 금액이 알맞는지.")
    @ParameterizedTest
    @CsvSource({
            "3, false, 5000",
            "4, true, 50000",
            "5, false, 1500000",
            "5, true, 30000000",
            "6, false, 2000000000"
    })
    void match(int matchCount, boolean matchBonus, int price) {
        Prize prizeThree = Prize.match(matchCount, matchBonus);
        assertThat(prizeThree.getPrize().getMoney()).isEqualTo(price);
    }

    @DisplayName("Enum에 정의 된 Constant객체들의 숫자와 알맞는지.")
    @ParameterizedTest
    @CsvSource({
            "THREE_MATCHES, 3",
            "FOUR_MATCHES, 4",
            "FIVE_MATCHES, 5",
            "FIVE_BONUS_MATCHES, 5",
            "SIX_MATCHES, 6",
            "ZERO_MATCHES, 0"
    })
    void isEqualCount(Prize p, int matchCount) {
        boolean res = p.isEqualCount(matchCount);
        assertThat(res).isEqualTo(true);
    }
}