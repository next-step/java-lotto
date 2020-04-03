package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BuyerResultTest {
    private BuyerResult buyerResult;

    @BeforeEach
    void setUp() {
        buyerResult = BuyerResult.of(Arrays.asList(Rank.FIRST, Rank.FOURTH, Rank.MISS));
    }

    @Test
    @DisplayName("구매 결과 조회")
    void create() {
        assertThat(buyerResult.getWinningResult()).containsExactly(Rank.FIRST, Rank.FOURTH, Rank.MISS);
    }

    @Test
    @DisplayName("구매 이율 계산")
    void calculateProfit() {
        assertThat(buyerResult.calculateProfitRate()).isEqualTo(BigDecimal.valueOf(666683.33));
    }
}