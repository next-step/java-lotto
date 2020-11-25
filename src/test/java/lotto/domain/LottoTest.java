package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void testGetPrice(){
        Integer testPrice = 1000;
        Lotto lotto = new Lotto(testPrice, new PrizeInfo());
        assertThat(lotto.getPrice()).isEqualTo(testPrice);
    }

    @Test
    void testGetPrizeInfo(){

        Long first_prize = 2000000000L;
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, first_prize, Currency.WON, "test");
        Lotto lotto = new Lotto(1000, prizeInfo);
        assertThat(lotto.getPrizeMap()).extractingByKey(Rank.FIRST).isEqualTo(new Prize(Rank.FIRST, first_prize, Currency.WON, "test"));
    }

    @Test
    void testGetPrizeMap(){
        Long first_prize = 2000000000L;
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, first_prize, Currency.WON, "test");
        Lotto lotto = new Lotto(1000, prizeInfo);
        assertThat(lotto.getPrizeMap()).extractingByKey(Rank.FIRST).isEqualTo(new Prize(Rank.FIRST, first_prize, Currency.WON, "test"));
    }
}
