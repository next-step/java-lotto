package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {
        "0, false, MISS",
        "1, true, MISS",
        "3, false, FIFTH",
        "5, true, SECOND",
        "5, false, THIRD",
        "6, false, FIRST"
    })
    public void 일치개수_보너스번호_포함여부에_따른_금액_도출(int match, boolean matchBonus, LottoPrice price) {
        assertThat(LottoPrice.valueOf(match, matchBonus)).isEqualTo(price);

    }

}
