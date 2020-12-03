package lotto.automatic.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoBuyingMoneyAndAmountTest {

    @Test
    @DisplayName("로또 구매 금액 인스턴스 생성")
    public void create_LottoMoney() {

        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(14000);
    }

    @Test
    @DisplayName("로또 구매 금액이 음수인 경우 ")
    public void 음수의_금액은_허용되지_않음() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoBuyingMoneyAndAmount(-1000)

        );
    }

    @Test
    @DisplayName("1000원 미만의 로또 구매 금액이 입력된 경우 ")
    public void 천원_미만_금액은_허용되지_않음() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoBuyingMoneyAndAmount(500)

        );
    }

    @Test
    @DisplayName("1000원 으로 살 수 있는 로또 수 확인")
    public void 천원으로_살_수_있는_로또_수_확인() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(1000);
        int countOfLotto = moneyAndAmount.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(1);
    }

    @Test
    @DisplayName("1500원 으로 살 수 있는 로또 수 확인")
    public void 천오백원으로_살_수_있는_로또_수_확인() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(1500);
        int countOfLotto = moneyAndAmount.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(1);
    }

    @Test
    @DisplayName("2000원 으로 살 수 있는 로또 수 확인")
    public void 이천원으로_살_수_있는_로또_수_확인() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(2000);
        int countOfLotto = moneyAndAmount.getCountOfLotto();
        assertThat(countOfLotto).isEqualTo(2);
    }

    @Test
    @DisplayName("1500원 으로 투자하는 로또 금액 확인")
    public void 천오백원으로_투자하는_로또_금액_확인() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(1500);
        int investMoney = moneyAndAmount.getInvestMoney();
        assertThat(investMoney).isEqualTo(1000);
    }

    @Test
    @DisplayName("1500원 지급시 거스름돈 확인")
    public void 천오백원_입력시_거스름돈_확인() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(1500);
        int changeMoney = moneyAndAmount.getChangeMoney();
        assertThat(changeMoney).isEqualTo(500);
    }

    @Test
    @DisplayName("수동수량 입력 테스트")
    public void 수동_구매_수량_입력_테스트() {
        LottoBuyingMoneyAndAmount moneyAndAmount = new LottoBuyingMoneyAndAmount(1500, 1);
        int manualAmount = moneyAndAmount.getManualAmount();
        int autoAmount = moneyAndAmount.getAutoAmount();
        assertThat(manualAmount).isEqualTo(1);
        assertThat(autoAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("수동수량 음수 입력 테스트")
    public void 수동_구매_수량_음수_입력_테스트() {

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoBuyingMoneyAndAmount(1500, -1)

        );
    }

}
