package lotto.domain;

import lotto.domain.enums.Currency;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeInfoTest {
    @Test
    void testGetPrizeMap(){
        Map<Rank, Long> expected = new HashMap<>();
        expected.putIfAbsent(Rank.FIRST, 20000000000L);
        expected.putIfAbsent(Rank.FIRST, 20000000000L);
        expected.putIfAbsent(Rank.THIRD, 20000000L);
        expected.putIfAbsent(Rank.FOURTH, 5000000L);
        expected.putIfAbsent(Rank.FIFTH, 5000L);

        PrizeInfo prizeInfo = new PrizeInfo();
        expected.forEach((rank, cash) -> prizeInfo.add(rank, new Cash(cash, Currency.WON), rank.name()));

        assertThat(prizeInfo.getPrizeMap()).isNotEmpty();
        assertThat(prizeInfo.getPrizeMap()).allSatisfy((rank, prize) -> {
            assertThat(expected.get(rank)).isEqualTo(prize.getCash().getAmount());
        });
    }
}
