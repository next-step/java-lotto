package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void testGetPrice(){
        Integer testPrice = 1000;
        Lotto lotto = new Lotto();
        lotto.setPrice(testPrice);
        assertThat(lotto.getPrice()).isEqualTo(testPrice);
    }

    @Test
    void testGetPrizeMap(){
        Lotto lotto = new Lotto();
        Long first_prize = 2000000000L;
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.add(Rank.FIRST, first_prize);
        lotto.setPrize(prizeInfo);
        assertThat(lotto.getPrize(Rank.FIRST)).isEqualTo(new Prize(Rank.FIRST, first_prize));
    }

    @Test
    void testGetConstraint(){
        Lotto lotto = new Lotto();
        lotto.setConstraint(new LottoConstraint(6, 45));
        LottoConstraint lottoConstraint = lotto.getConstraint();
        assertThat(lottoConstraint).isNotNull();
        assertThat(lottoConstraint.getCountOfNumber()).isEqualTo(6);
        assertThat(lottoConstraint.getRange()).isEqualTo(45);
    }
}
