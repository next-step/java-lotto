package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("조건에 맞는 등수를 구할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,UN_RANK", "1,UN_RANK"})
    void countOf(int count, String expected) {
        // when
        Rank rank = Rank.countOf(count);

        // then
        assertThat(rank).isEqualTo(Rank.valueOf(expected));
    }

    @DisplayName("각 등수는 상금을 가지고 있다.")
    @ParameterizedTest
    @CsvSource(value = {"FIRST,2000000000", "SECOND,1500000", "THIRD,50000", "FOURTH,5000", "UN_RANK,0"})
    void reward(String value, long amount) {
        // when
        Rank rank = Rank.valueOf(value);
        Money reward = rank.getReward();

        // then
        assertThat(reward).isEqualTo(Money.valueOf(amount));
    }
}
