package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.EnumMap;

import static java.math.RoundingMode.HALF_EVEN;
import static lotto.model.Profit.LOTTO_PRICE;
import static lotto.model.Profit.SCALE;
import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    private Profit profit;
    private final EnumMap<Rank, Integer> winningMatch = new EnumMap<>(Rank.class);

    @BeforeEach
    void setup() {
        profit = new Profit(10);
    }

    @Test
    @DisplayName("수익률이 0이면 0을 반환한다")
    void profit_zero() {
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 0);

       assertThat(profit.calculate(new RankCount(winningMatch)))
               .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("수익률이 0이아니면 수익률을 반환한다")
    void profit_notZero() {
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 1);

        assertThat(profit.calculate(new RankCount(winningMatch)))
                .isEqualTo(BigDecimal.valueOf(FOUR.getPrice())
                        .divide(BigDecimal.valueOf((long) 10 * LOTTO_PRICE),
                                SCALE, HALF_EVEN));
    }

    @Test
    @DisplayName("수익률이 0이아니면 수익률을 반환한다 : 2등포함")
    void profit_bonus() {
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 1);
        winningMatch.put(TWO, 1);

        assertThat(profit.calculate(new RankCount(winningMatch)))
                .isEqualTo(BigDecimal.valueOf(FOUR.getPrice() + TWO.getPrice())
                        .divide(BigDecimal.valueOf((long) 10 * LOTTO_PRICE),
                        SCALE, HALF_EVEN));
    }
}