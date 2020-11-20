package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void testGetRank(){
        Prize prize = new Prize(Rank.FIRST, 10000L, Currency.WON, "다맞으면");
        assertThat(prize.getRank()).isEqualTo(Rank.FIRST);
    }

    @Test
    void testSameHashCode(){
        Prize prize1 = new Prize(Rank.FIRST, 10000L, Currency.WON, "다맞으면");
        Prize prize2 = new Prize(Rank.FIRST, 10000L, Currency.WON, "다맞으면");

        assertThat(prize1.hashCode()).isEqualTo(prize2.hashCode());
    }

    @Test
    void testGetCashString(){
        Prize prize = new Prize(Rank.FIRST, 10000L, Currency.WON, "다맞으면");
        assertThat(prize.getCashString()).isEqualTo("10000 원");
        assertThat(prize.getRuleDescription()).isEqualTo("다맞으면");
    }
}
