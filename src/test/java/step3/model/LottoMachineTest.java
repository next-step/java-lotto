package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 금액을 입력받으면 1000으로 나눈값을 내려준다. O
- 로또 변호 6자리를 랜덤으로 출력한다. O
- 입력받은 숫자만큼 로또번호를 출력한다. O
- 입력받은 금액이 1000원 이하이면 예외를 발생시킨다. O
- 로또 생성시 음수를 입력받으면 예외를 발생시킨다. O
- 수동으로 로또 번호를 입력받는다. O
- 수동으로 구매한 금액을 가져온다. O
*/
public class LottoMachineTest extends GlobalTest {

    @DisplayName("금액을 입력받으면 1000으로 나눈값을 내려준다.")
    @Test
    void receiveMoneyTest() {
        int money = 10000;

        step2.model.LottoMachine lottoMachine = new step2.model.LottoMachine();
        int num = lottoMachine.receiveMoney(money);

        assertThat(num).isEqualTo(10);
    }

    @DisplayName("입력받은 금액이 1000원 이하라면 예외를 발생시킨다.")
    @Test
    void receiveMoneyThrowExceptionTest() {
        int money = 900;

        step2.model.LottoMachine lottoMachine = new step2.model.LottoMachine();

        assertThatThrownBy(() -> lottoMachine.receiveMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 가격은 1000원입니다.");
    }

    @DisplayName("로또 변호 6자리를 랜덤으로 출력한다.")
    @Test
    void lottoNumTest() {
        step2.model.LottoMachine lottoMachine = new step2.model.LottoMachine();
        List<Integer> lotto = lottoMachine.outputLotto();

        assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("입력받은 숫자만큼 로또번호를 출력한다.")
    @Test
    void getLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        lottoMachine.getAutoLotto(purchasedLotto, 3);

        assertThat(purchasedLotto.getPurchasedLotto().size()).isEqualTo(3);
    }

    @DisplayName("입력받은 숫자가 음수이면 예외를 발생시킨다.")
    @Test
    void getLottoThrowExceptionTest() {
        LottoMachine lottoMachine = new LottoMachine();
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        assertThatThrownBy(() -> lottoMachine.getAutoLotto(purchasedLotto, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 최소 1장이상부터 생성이 가능합니다.");
    }

    @DisplayName("수동으로 로또번호를 입력받는다.")
    @Test
    void getManualLottoTest() {
        ManualLotto manualLotto = new ManualLotto(
                List.of("1,2,3,4,5,6", "2,3,4,5,7,10", "10,23,15,24,36,34")
        );

        PurchasedLotto purchasedLotto = new PurchasedLotto();

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.getManualLotto(purchasedLotto, manualLotto);

        assertThat(purchasedLotto.getPurchasedLotto()).containsExactly(
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(2, 3, 4, 5, 7, 10),
                createLotto(10, 15, 23, 24, 34, 36)
        );
    }

    @DisplayName("수동으로 로또번호를 입력받는다.")
    @Test
    void manualLottoMoneyTest() {
        ManualLotto manualLotto = new ManualLotto(
                List.of("1,2,3,4,5,6", "2,3,4,5,7,10", "10,23,15,24,36,34")
        );

        LottoMachine lottoMachine = new LottoMachine();
        ;

        assertThat(lottoMachine.manualLottoMoney(manualLotto)).isEqualTo(3000);
    }

}
