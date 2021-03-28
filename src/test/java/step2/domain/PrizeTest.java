package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0", "1,0,0", "2,0,0", "3,3,5000", "4,4,50000", "5,5,1500000", "6,6,2000000000"})
    void findPrize(int findCount, int expectedCount, int expectedAmount) {
        Prize prize = Prize.findPrize(findCount);
        assertThat(prize.getMatchCount()).isEqualTo(expectedCount);
        assertThat(prize.getAmount()).isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,2", "5,3", "6,4"})
    void findMatchPrizes(int findCount, int expectedSize) {
        // given
        List<Prize> prizes = new ArrayList<>();
        prizes.add(Prize.THREE_MATCH);

        prizes.add(Prize.FOUR_MATCH);
        prizes.add(Prize.FOUR_MATCH);

        prizes.add(Prize.FIVE_MATCH);
        prizes.add(Prize.FIVE_MATCH);
        prizes.add(Prize.FIVE_MATCH);

        prizes.add(Prize.ALL_MATCH);
        prizes.add(Prize.ALL_MATCH);
        prizes.add(Prize.ALL_MATCH);
        prizes.add(Prize.ALL_MATCH);

        // when
        int prizesSize = Prize.findMatchPrizes(prizes, Prize.findPrize(findCount)).size();

        // then
        assertThat(prizesSize).isEqualTo(expectedSize);
    }
}