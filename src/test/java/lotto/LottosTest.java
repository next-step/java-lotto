package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @ParameterizedTest
    @CsvSource(value = {"5000,5", "2000,2"}, delimiter = ',')
    @DisplayName("금액만큼 로또를 생성한다.")
    void generateByMoney(int input, int expectedCount) {
        Lottos lottos = LottoGenerator.generateByMoney(new Money(input));
        assertThat(lottos.getLottoCount()).isEqualTo(expectedCount);
    }
}