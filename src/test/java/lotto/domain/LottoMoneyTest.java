package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("금액이 1000원 아래이면 로또를 구입할 수가 없어 Exception 발생")
    @ParameterizedTest
    @ValueSource(longs = {0, 10, 999})
    void validateMoney(long value) {
        assertThatThrownBy(() -> new LottoMoney(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 살 수가 없습니다.");
    }

    @DisplayName("입력받은 수동 로또 장 수가 발급받을 수 있는 총 로또 장 수를 초과했을 경우 Exception 발생")
    @ParameterizedTest
    @CsvSource(value = {"1000:2", "20000:22"}, delimiter = ':')
    void getCountOfAutoLotto_false(long value, int countOfManualLotto) {
        LottoMoney lottoMoney = new LottoMoney(value);
        assertThatThrownBy(() -> lottoMoney.getCountOfAutoLotto(countOfManualLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매할 수 있는 로또 장 수를 초과했습니다.");
    }

    @DisplayName("총 로또 티켓 갯수(1000원당 로또 티켓 한 장)에서 수동 로또 티켓 갯수를 빼서 자동 로또 티켓 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"13000:7:6", "20000000000:10000000:10000000"}, delimiter = ':')
    void getCountOfAutoLotto(long value, int countOfManualLotto, int expected) {
        int countOfAutoLotto = new LottoMoney(value).getCountOfAutoLotto(countOfManualLotto);
        assertThat(countOfAutoLotto).isEqualTo(expected);
    }

    @DisplayName("받게 될 총 당첨 금액으로 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"14000:5000:0.35", "5000:5000:1.0"}, delimiter = ':')
    void calculateYield(long value, long sum, double expected) {
        LottoMoney lottoMoney = new LottoMoney(value);
        assertThat(lottoMoney.calculateYield(sum)).isEqualTo(expected);
    }
}
