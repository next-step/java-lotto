package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    public static final Long THREE_PRICE = 5000L;
    public static final Long FOUR_PRICE = 50_000L;
    public static final Long FIVE_PRICE = 1_500_000L;
    public static final Long SIX_PRICE = 2_000_000_000L;

    @Test
    void winningPriceTest() {
        assertThat(Price.winningPrice(0)).isEqualTo(0L);
        assertThat(Price.winningPrice(1)).isEqualTo(0L);
        assertThat(Price.winningPrice(2)).isEqualTo(0L);
        assertThat(Price.winningPrice(3)).isEqualTo(THREE_PRICE);
        assertThat(Price.winningPrice(4)).isEqualTo(FOUR_PRICE);
        assertThat(Price.winningPrice(5)).isEqualTo(FIVE_PRICE);
        assertThat(Price.winningPrice(6)).isEqualTo(SIX_PRICE);
    }



    @Test
    void calculateTest() {
        //given
        int[] match = new int[]{0, 1, 2, 3, 4, 5, 6};
        Long expectMatch = 0 * 0 + 1 * 0 + 2 * 0
                + 3 * THREE_PRICE + 4 * FOUR_PRICE + 5 * FIVE_PRICE + 6 * SIX_PRICE;

        //when
        Long result = Price.calculate(match);

        //then
        assertThat(result).isEqualTo(expectMatch);
    }
}
