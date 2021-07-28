package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMatchTypeTest {

    @DisplayName("입력값에 따른 금액을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0:false", "3:5000:false", "4:50000:false", "5:1500000:false", "5:30000000:true", "6:2000000000:false"}, delimiter = ':')
    void lotto_match_type(int count, long money, boolean matchBonus) {
        LottoMatchType matchType = LottoMatchType.findMatchCount(count, matchBonus);
        assertThat(matchType.getWinMoney()).isEqualTo(money);
    }
}