package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.WinningInfo;
import step2.dto.WinningRate;

import java.util.EnumMap;

class WinningResultInfoTest {
    EnumMap<WinningCondition, WinningInfo> resultInfo;

    @BeforeEach
    public void setup() {
        resultInfo = new EnumMap<>(WinningCondition.class);

        int matchCount = 0;
        for (WinningCondition condition : WinningCondition.values()) {
            resultInfo.put(condition, new WinningInfo(condition.getMatchedCondition(), condition.getWinningPrize(), matchCount++));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"10000: 600305.0", "20000: 300152.5", "500000: 12006.1"}, delimiter = ':')
    @DisplayName("구매한 비용을 인자로 받으면 구매한 비용대비 당첨 수익률을 반환한다")
    void calculateRate(long input, float expected) {
        Assertions.assertThat(new WinningResultInfo(resultInfo).calculateRate(new Money(input))).isEqualTo(new WinningRate(expected));
    }
}
