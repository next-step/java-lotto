package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2,})
    void getDefaultWin(int matchCount) {
        // given
        // when
        Rank rank = Rank.of(matchCount);

        // then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void getSecondWin() {
        // given
        // when
        Rank rank = Rank.of(5);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 5000",
            "4, 50000",
            "5, 1500000",
            "6, 2000000000",
    })
    void winPriceOf_Default(int matchCount, int winPrice) {
        // given
        // when
        Money money = Rank.winPriceOf(matchCount);

        // then
        assertThat(money).isEqualTo(new Money(winPrice));
    }

}
