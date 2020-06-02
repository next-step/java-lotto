package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step2.domain.WinningTable;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTableTest {

    @ParameterizedTest
    @DisplayName("로또번호 일치 갯수에 맞는 당첨금 수령하는지 테스트")
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    public void lottoPrizeMoneyTest(int matchingCount, int prizeMoney){
        assertThat(WinningTable.findRanking(matchingCount).getPrizeMoney()).isEqualTo(prizeMoney);
    }
}
