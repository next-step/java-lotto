package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayTest {
    @DisplayName("지불 금액 객체 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "2500:2500"}, delimiter = ':')
    void createPay(int payForLotto, int expectedPay) {
        Pay pay = new Pay(payForLotto);
        assertThat(pay).isEqualTo(new Pay(expectedPay));
    }

    @DisplayName("지불 금액 만큼 살 수 있는 로또")
    @ParameterizedTest
    @CsvSource(value = {"1100:1:1000", "167889:167:1000"}, delimiter = ':')
    void countCanBuyLotto_로또_몇장_살수_있나(int payForLotto, int countLotto, int costLotto) {
        Pay pay = new Pay(payForLotto);
        assertThat(countLotto).isEqualTo(pay.countBuyLotto(costLotto));
    }

    @DisplayName("천원 이하로 로또 사려고 하면 오류 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 100, 900, 500})
    void isNotCost_천원_이하_오류(int payForLotto) {
        assertThatThrownBy(() -> new Pay(payForLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동 번호를 살 수 있는 갯수")
    @ParameterizedTest
    @CsvSource(value = {"1100:1:0", "2100:1:1"}, delimiter = ':')
    void countAutoLotto_자동_번호_개수(int payForLotto, int manualLottoCount, int autoLottoCount) {
        Pay pay = new Pay(payForLotto);
        assertThat(pay.countAutoLotto(manualLottoCount)).isEqualTo(autoLottoCount);
    }
}
