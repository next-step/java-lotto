package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "번호 {0}개 일치 => 등수 : {1}")
    @CsvSource(value = {"6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH", "2:NONE", "1:NONE", "0:NONE"}, delimiter = ':')
    void Rank담기(int matchCount, String rankName) {
        Rank rank = Rank.of(matchCount, false);
        assertThat(rank.name()).isEqualTo(rankName);
    }

    @Test
    void Rank담기_2등() {
        Rank rank = Rank.of(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest(name = "번호 {0}개 일치 => 상금 : {1}")
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000", "2:0", "1:0", "0:0"}, delimiter = ':')
    void 상금(int matchCount, int expectedPrize) {
        Rank rank = Rank.of(matchCount, false);
        assertThat(rank.getPrize()).isEqualTo(expectedPrize);
    }

    @Test
    void 상금_2등() {
        Rank rank = Rank.of(5, true);
        assertThat(rank.getPrize()).isEqualTo(Rank.SECOND.getPrize());
    }
}