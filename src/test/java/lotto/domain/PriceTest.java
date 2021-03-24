package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.Price.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {
    @Test
    void calculateTest() {
        //given
        int[] match = new int[]{0, 1, 2, 3, 4, 5, 6};
        Long expectMatch = 0 * 0 + 1 * 0 + 2 * 0
                + 3 * THREE_MATCH_PRICE + 4 * FOUR_MATCH_PRICE + 5 * FIVE_MATCH_PRICE + 6 * SIX_MATCH_PRICE;

        //when
        Long result = Price.calculate(match);

        //then
        assertThat(result).isEqualTo(expectMatch);
    }
}
