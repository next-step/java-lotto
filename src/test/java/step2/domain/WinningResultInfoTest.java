package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.WinningRate;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.WinningCondition.*;

class WinningResultInfoTest {
    EnumMap<WinningCondition, WinningInfo> resultInfo;

    @BeforeEach
    public void setup() {
        resultInfo = new EnumMap<>(WinningCondition.class);

        resultInfo.put(WIN_1TH, new WinningInfo(WIN_1TH.getWinningPrize(), 0));
        resultInfo.put(WIN_2TH, new WinningInfo(WIN_2TH.getWinningPrize(), 0));
        resultInfo.put(WIN_3TH, new WinningInfo(WIN_3TH.getWinningPrize(), 0));
        resultInfo.put(WIN_4TH, new WinningInfo(WIN_4TH.getWinningPrize(), 1));
        resultInfo.put(WIN_5TH, new WinningInfo(WIN_5TH.getWinningPrize(), 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"10000: 5", "20000: 2.5", "500000: 0.1"}, delimiter = ':')
    @DisplayName("구매한 비용을 인자로 받으면 구매한 비용대비 당첨 수익률을 반환한다")
    void calculateRate(long input, float expected) {
        assertThat(new WinningResultInfo(resultInfo).calculateRate(new Money(input))).isEqualTo(new WinningRate(expected));
    }
}
