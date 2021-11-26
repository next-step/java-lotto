package lotto.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RankTest {

    @DisplayName("일치 개수에 따른 Rank")
    @ParameterizedTest
    @ValueSource(ints = {6, 5, 4, 3, 2, 0})
    void create(int matchCount) {
        assertThat(Rank.valueOf(matchCount)).isEqualTo(Rank.valueOf(matchCount));
    }

    @DisplayName("일치 개수에 따른 Rank(일치 개수가 음수_실패)")
    @Test
    void create_negative_match_count_fail() {
        assertThatThrownBy(() -> Rank.valueOf(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("일치 개수는 음수일 수 없습니다.");
    }

}
