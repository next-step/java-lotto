package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MatchResultTest {
    @ParameterizedTest
    @CsvSource(value = {"3:5000:15000", "4:50000:200000"}, delimiter = ':')
    void 상금_테스트(int matchNumber, int reward, int totalReward) {
        assertThat(new MatchResult(matchNumber, reward).getReward()).isEqualTo(totalReward);
    }
}
