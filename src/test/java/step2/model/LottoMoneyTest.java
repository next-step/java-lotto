package step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.LottoLowMoneyException;

public class LottoMoneyTest {

    @DisplayName("금액별 구매 개수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "2000:2"}, delimiter = ':')
    void 금액별_구매_개수_테스트(int inputMony, int excepted) {
        assertThat(new LottoMoney(inputMony).getLottoCount()).isEqualTo(excepted);
        assertThat(new LottoMoney(inputMony).getLottoCount()).isEqualTo(excepted);
        assertThat(new LottoMoney(inputMony).getLottoCount()).isEqualTo(excepted);
    }

    @DisplayName("1000 미만의 금액을 입력했을 경우")
    @Test
    void 적은_금액_테스트() {
        assertThatExceptionOfType(LottoLowMoneyException.class)
            .isThrownBy(() -> new LottoMoney(900));
    }
}
