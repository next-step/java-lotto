package lotto.models.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @CsvSource({"FIRST, 6", "SECOND, 5", "THIRD, 4", "FOURTH, 3"})
    @DisplayName("맞춘 숫자에 따라 알맞는 Rank enum을 생성한다.")
    void getRank1(Rank rank, int equalCount) {
        assertThat(Rank.of(equalCount)).isEqualTo(rank);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("2개 이하로 맞춘 경우, OTHER Rank enum을 생성한다.")
    void getRank2(int equalCount) {
        assertThat(Rank.of(equalCount)).isEqualTo(Rank.OTHER);
    }
}
