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
*/
public class LottoMachineTest {

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
        Lotto lotto = lottoMachine.getLotto(3);

        assertThat(lotto.getLottos().size()).isEqualTo(3);
    }

    @DisplayName("입력받은 숫자가 음수이면 예외를 발생시킨다.")
    @Test
    void getLottoThrowExceptionTest() {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.getLotto(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 최소 1장이상부터 생성이 가능합니다.");
    }

}
