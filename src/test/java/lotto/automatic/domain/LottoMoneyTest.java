package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMoneyTest {

    @Test
    @DisplayName("로또 구매 금액 인스턴스 생성")
    public void create_LottoMoney() {

        LottoMoney money = new LottoMoney(14000);
    }

    @Test
    @DisplayName("로또 구매 금액이 음수인 경우 ")
    public void 음수의_금액은_허용되지_않음() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoMoney(-1000)

        );
    }

    @Test
    @DisplayName("1000원 미만의 로또 구매 금액이 입력된 경우 ")
    public void 천원_미만_금액은_허용되지_않음() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoMoney(500)

        );
    }

    @Test
    @DisplayName("1000원 으로 살 수 있는 로또 수 확인")
    public void 천원으로_살_수_있는_로또_수_확인() {
        LottoMoney money = new LottoMoney(1000);
        int countOfLotto = money.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(1);
    }

    @Test
    @DisplayName("1500원 으로 살 수 있는 로또 수 확인")
    public void 천오백원으로_살_수_있는_로또_수_확인() {
        LottoMoney money = new LottoMoney(1500);
        int countOfLotto = money.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(1);
    }

    @Test
    @DisplayName("2000원 으로 살 수 있는 로또 수 확인")
    public void 이천원으로_살_수_있는_로또_수_확인() {
        LottoMoney money = new LottoMoney(2000);
        int countOfLotto = money.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(2);
    }

}
