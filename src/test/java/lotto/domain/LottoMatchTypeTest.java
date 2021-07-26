package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMatchTypeTest {

    @DisplayName("입력값에 따른 금액을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void lotto_match_type(int count, long money) {
        LottoMatchType matchType = LottoMatchType.findMatchCount(count);
        assertThat(matchType.getWinMoney()).isEqualTo(money);
    }
}