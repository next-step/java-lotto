package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void testGetPrice(){
        Long testPrice = 1000L;
        Lotto lotto = new Lotto(new Cash(testPrice, Currency.WON), new PrizeInfo());
        assertThat(lotto.getPrice().getAmount()).isEqualTo(testPrice);
    }

    @Test
    void testGetPrizeInfo(){

        Long first_prize = 2000000000L;
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, new Cash(first_prize, Currency.WON), "test");
        Lotto lotto = new Lotto(new Cash(1000L, Currency.WON), prizeInfo);
        assertThat(lotto.getPrizeMap()).extractingByKey(Rank.FIRST).isEqualTo(new Prize(Rank.FIRST, new Cash(first_prize, Currency.WON), "test"));
    }

    @Test
    void testGetPrizeMap(){
        Long first_prize = 2000000000L;
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, new Cash(first_prize, Currency.WON), "test");
        Lotto lotto = new Lotto(new Cash(1000L,Currency.WON), prizeInfo);
        assertThat(lotto.getPrizeMap()).extractingByKey(Rank.FIRST).isEqualTo(new Prize(Rank.FIRST, new Cash(first_prize, Currency.WON), "test"));
    }
}
