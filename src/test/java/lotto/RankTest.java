package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @CsvSource({
            "0,MISS",
            "3,FIFTH",
            "4,FOURTH",
            "5,THIRD",
            "6,FIRST"
    })
    @DisplayName("일치되는 개수로 enum 을 조회한다")
    void getEnumByCountOfMatch(int countOfMatch, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch)).isEqualTo(rank);
    }
}
