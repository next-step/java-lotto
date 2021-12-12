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

        resultInfo.put(WinningCondition.WIN_1TH, new WinningInfo(WinningCondition.WIN_1TH.getWinningPrize(), 0));
        resultInfo.put(WinningCondition.WIN_2TH, new WinningInfo(WinningCondition.WIN_2TH.getWinningPrize(), 0));
        resultInfo.put(WinningCondition.WIN_3TH, new WinningInfo(WinningCondition.WIN_3TH.getWinningPrize(), 0));
        resultInfo.put(WinningCondition.WIN_4TH, new WinningInfo(WinningCondition.WIN_4TH.getWinningPrize(), 1));
        resultInfo.put(WinningCondition.WIN_5TH, new WinningInfo(WinningCondition.WIN_5TH.getWinningPrize(), 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"10000: 5", "20000: 2.5", "500000: 0.1"}, delimiter = ':')
    @DisplayName("구매한 비용을 인자로 받으면 구매한 비용대비 당첨 수익률을 반환한다")
    void calculateRate(long input, float expected) {
        Assertions.assertThat(new WinningResultInfo(resultInfo).calculateRate(new Money(input))).isEqualTo(new WinningRate(expected));
    }
}
