package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.EnumMap;

import static lotto.model.Rank.FOUR;
import static lotto.model.Rank.MISS;
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

       assertThat(profit.calculate(matchingCollection())).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("수익률이 0이아니면 수익률을 반환한다")
    void profit_notZero() {
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 1);

        assertThat(profit.calculate(matchingCollection()))
                .isEqualTo(profit.calculateRevenue(BigDecimal.valueOf(FOUR.getPrice())));
    }

    @Test
    @DisplayName("일치한 로또가격이 없으면 수익률이 0이다 ")
    void profit2() {
        winningMatch.put(MISS, 2);
        winningMatch.put(FOUR, 1);
        System.out.println("테스트1 =" + matchingCollection().calculateBenefit());
        System.out.println("테스트2= " + profit.calculateRevenue(matchingCollection().calculateBenefit()));
    }

    private MatchingCollection matchingCollection() {
        return new MatchingCollection(winningMatch);
    }
}