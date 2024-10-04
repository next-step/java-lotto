package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.enums.ExceptionMessage;
import step2.model.Lotto;
import step2.model.LottoMachine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 금액을 입력받으면 1000으로 나눈값을 내려준다. O
- 로또 변호 6자리를 랜덤으로 출력한다. O
- 입력받은 숫자만큼 로또번호를 출력한다. O
- 입력받은 금액이 1000원 이하이면 예외를 발생시킨다. O
- 로또 생성시 음수를 입력받으면 예외를 발생시킨다. O
*/
public class LottoMachineTest {

    @DisplayName("금액을 입력받으면 1000으로 나눈값을 내려준다.")
    @Test
    void receiveMoneyTest() {
        int money = 10000;

        LottoMachine lottoMachine = new LottoMachine();
        int num = lottoMachine.receiveMoney(money);

        assertThat(num).isEqualTo(10);
    }

    @DisplayName("입력받은 금액이 1000원 이하라면 예외를 발생시킨다.")
    @Test
    void receiveMoneyThrowExceptionTest() {
        int money = 900;

        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.receiveMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUM_LOTTO_PRICE.message());
    }

    @DisplayName("로또 변호 6자리를 랜덤으로 출력한다.")
    @Test
    void lottoNumTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lotto = lottoMachine.outputLotto();

        assertThat(lotto.size()).isEqualTo(6);
    }

    @DisplayName("입력받은 숫자만큼 로또번호를 출력한다.")
    @Test
    void getLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.getLotto(3, 3000);

        assertThat(lotto.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("입력받은 숫자가 음수이면 예외를 발생시킨다.")
    @Test
    void getLottoThrowExceptionTest() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.getLotto(-1, 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUM_LOTTO_NUM.message());
    }

}
