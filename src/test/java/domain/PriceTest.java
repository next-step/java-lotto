package domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PriceTest {
    private static final int ONE_TICKET_PRICE = 1_000;
    private static final int TOTAL_AMOUNT = 14_000;
    private static final BigDecimal TOTAL_WINNING_PRICE = BigDecimal.valueOf(9_000_000);
    private Price price;

    @Before
    public void setUp() {
        price = new Price(TOTAL_AMOUNT);
    }

    @Test
    public void 구매_가능한_ticket_count_구하기() {
        assertThat(price.ticketCount()).isEqualTo(TOTAL_AMOUNT/ONE_TICKET_PRICE);
    }

    @Test
    public void 총_수익률_구하기() {
        assertThat(price.totalRateByWinning(TOTAL_WINNING_PRICE))
                .isEqualTo( TOTAL_WINNING_PRICE.divide(BigDecimal.valueOf(TOTAL_AMOUNT), 2, RoundingMode.HALF_UP));
    }
}
