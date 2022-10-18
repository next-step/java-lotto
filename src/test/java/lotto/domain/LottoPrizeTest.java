package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @DisplayName("로또 매칭 갯수별 상금 조회")
    @CsvSource(
            delimiter = ':',
            value = {"0:0:false", "1:0:false", "2:0:false", "3:5000:false", "4:50000:false", "5:1500000:false", "5:30000000:true", "6:2000000000:false"}
    )
    void selectPrize(int matchedNumber, int prizeMoney, boolean matchBonus) {
        assertThat(LottoPrize.of(matchedNumber, matchBonus).amount())
                .isEqualTo(prizeMoney);
    }

    @ParameterizedTest
    @DisplayName("2등이 아닐 떄, 보너스 번호 포함 검증")
    @CsvSource(
            delimiter = ':',
            value = {"0:0:true", "1:0:true", "2:0:true", "3:5000:true", "4:50000:true", "5:30000000:true", "6:2000000000:true"}
    )
    void notSecondPrizeAndContainBonusNumber(int matchedNumber, int prizeMoney, boolean matchBonus) {
        assertThat(LottoPrize.of(matchedNumber, matchBonus).amount())
                .isEqualTo(prizeMoney);
    }
}
