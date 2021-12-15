package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RankTest {

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {3,4,6})
    void 등수_자격(int param) {
        Rank rank = Rank.valueOf(param, false);
        assertThat(rank.getMatchCount()).isEqualTo(param);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {1,2,9})
    void 등수_미자격(int param) {
        assertThatThrownBy(() -> {
            Rank.valueOf(param, false);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @CsvSource(value = {"5:false:1500000", "5:true:30000000"}, delimiter = ':')
    void create(int matchCount, boolean param, int winningMoney) {
        Rank rank = Rank.valueOf(matchCount, param);
        assertThat(rank.getWinningMoney()).isEqualTo(winningMoney);
    }
}
