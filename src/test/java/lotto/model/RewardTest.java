package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RewardTest {

    @DisplayName("로또 맞은 개수에 따라 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,NONE", "2,NONE", "3,FOURTH","4,THIRD", "5,SECOND", "6,FIRST"})
    void findRank(int input, Rank expected) {
        assertThat(Rank.findRank(input)).isEqualTo(expected);
    }
}
