package step5.winning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningPrizeTest {

    @BeforeEach
    void setUp() {
    }

    @DisplayName("일치 개수를 입력하면 해당하는 등수의 상금을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"3:false:5000", "4:false:50000", "5:false:1500000", "5:true:30000000", "6:false:2000000000"}, delimiter = ':')
    void valueOf(int matchCount, boolean isBonusNumber, int expectedPrizeMoney) {
        // given
        WinningPrize winningPrize = WinningPrize.valueOf(matchCount, isBonusNumber);

        // when
        int prizeMoney = winningPrize.getWinningMoney();

        // then
        assertThat(prizeMoney).isEqualTo(expectedPrizeMoney);
    }
}