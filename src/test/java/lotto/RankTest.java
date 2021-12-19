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
        Rank rank = Rank.of(matchCount, false);

        // then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    void getSecondWin() {
        // given
        // when
        Rank rank = Rank.of(5, true);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void getThirdWin() {
        // given
        // when
        Rank rank = Rank.of(5, false);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @CsvSource({
            "0, false, 0",
            "1, false, 0",
            "2, false, 0",
            "3, false, 5000",
            "4, false, 50000",
            "5, false, 1500000",
            "5, true, 30000000",
            "6, false, 2000000000",
    })
    void winPriceOf_Default(int matchCount, boolean bonusMatch, int winPrice) {
        // given
        Rank rank = Rank.of(matchCount, bonusMatch);

        // when
        Money money = rank.winPrice();

        // then
        assertThat(money).isEqualTo(new Money(winPrice));
    }

}
