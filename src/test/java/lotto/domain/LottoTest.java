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
    void testGetWinningNumber(){
        Integer[] winningNumber = {3,4,20,21,34,43};
        Lotto lotto = new Lotto();
        lotto.setWinningNumber(winningNumber);
        assertThat(lotto.getWinningNumber()).containsExactly(winningNumber);
    }

    @Test
    void testGetPrizeMap(){
        Lotto lotto = new Lotto();
        int first_prize = 2000000000;
        lotto.addToPrizeMap(Rank.FIRST, first_prize);
        assertThat(lotto.getPrizeMap()).extractingByKey(Rank.FIRST).isEqualTo(first_prize);
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
