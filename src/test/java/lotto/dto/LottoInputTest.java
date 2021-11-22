package lotto.dto;

import lotto.vo.LottoRule;
import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoInputTest {

    @DisplayName("자동 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:3:2", "5500:3:2", "10000:2:8"}, delimiter = ':')
    void getAutoCountTest(int money, int manualCount, int autoCount) {
        LottoInput lottoInput = new LottoInput(Money.create(money), manualCount, Collections.EMPTY_LIST);

        assertThat(lottoInput.getAutoCount(Money.create(LottoRule.LOTTO_PRICE.getValue()))).isEqualTo(autoCount);
    }

}
