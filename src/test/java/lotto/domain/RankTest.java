package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("조건에 맞는 등수를 구할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,false,FOURTH", "3,false,FIFTH", "1,false,UN_RANK"})
    void countOf(int count, boolean matchBonus, String expected) {
        // when
        Rank rank = Rank.countOf(count, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.valueOf(expected));
    }

    @DisplayName("각 등수는 상금을 가지고 있다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,2000000000", "SECOND,30000000", "THIRD,1500000", "FOURTH,50000", "FIFTH,5000", "UN_RANK,0"})
    void reward(String value, long amount) {
        // when
        Rank rank = Rank.valueOf(value);
        Money reward = rank.getReward();

        // then
        assertThat(reward).isEqualTo(Money.valueOf(amount));
    }

    @DisplayName("당첨된 등 수 인지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,true", "SECOND,true", "THIRD,true", "FOURTH,true", "UN_RANK,false"})
    void isWinning(String value, boolean expected) {
        // when
        Rank rank = Rank.valueOf(value);
        boolean winning = rank.isWinning();

        // then
        assertThat(winning).isEqualTo(expected);
    }
}
