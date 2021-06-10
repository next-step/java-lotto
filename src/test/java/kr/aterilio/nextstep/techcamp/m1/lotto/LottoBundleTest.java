package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBundleTest {

    @DisplayName("로또 구입 금액을 입력받으면 로또를 구매한다. (1000원당 1장)")
    @ParameterizedTest
    @CsvSource(value = {"3000,3", "14000,14", "8000,8"})
    public void buyLotto(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -5000, -100})
    public void buyLottoFailed(int money) {
        assertThatThrownBy(() -> {
            new LottoBundle(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 이상");
    }

    @DisplayName("'수동으로 구매할 로또 수'가 구매 금액으로 구매할 수 있는 것보다 클 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,2"})
    public void buyLottoFailed_insufficientMoney(int money, int manualCount) {
        assertThatThrownBy(() -> {
            new LottoBundle(money, manualCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("충분하지 않습니다");
    }
}
