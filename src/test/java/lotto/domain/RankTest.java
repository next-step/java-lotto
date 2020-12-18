package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void rank_1등() {
        Rank result = Rank.valueOf(6, false);
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    void rank_2등() {
        Rank result = Rank.valueOf(5, true);
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    void rank_3등() {
        Rank result = Rank.valueOf(5, false);
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void rank_4등(boolean matchBonus) {
        Rank result = Rank.valueOf(4, matchBonus);
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void rank_5등(boolean matchBonus) {
        Rank result = Rank.valueOf(3, matchBonus);
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void rank_꼴찌(boolean matchBonus) {
        Rank result = Rank.valueOf(0, matchBonus);
        assertThat(result).isEqualTo(Rank.MISS);
    }

    @DisplayName("입력받은 수만큼 해당 당첨금액을 곱한다.")
    @Test
    void multiplyMoney() {
        long result = Rank.FIFTH.multiplyMoney(3);
        assertThat(result).isEqualTo(15000);
    }
}
