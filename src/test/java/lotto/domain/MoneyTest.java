package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("입력한 금액으로 로또를 몇장 구매할 수 있는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"13500:13","5000:5"}, delimiter = ':')
    void lottoCountTest(int money, int lottoCount) {
        Money actual = new Money(money);

        assertThat(actual.lottoCount()).isEqualTo(lottoCount);
    }
}
