package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5000","4:50000","5:1500000","6:2000000000"}, delimiter = ':')
    @DisplayName("성공 - 당첨 개수에 맞는 당첨 금액을 반환한다.")
    void test(int matchCount, int prizeAmount){
        assertThat(LottoPrice.prizeAmount(matchCount)).isEqualTo(prizeAmount);
    }

}
