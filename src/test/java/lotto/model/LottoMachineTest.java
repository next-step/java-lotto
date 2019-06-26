package lotto.model;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("잔액 부족으로 로또 구매 실패")
    @Test
    void buyLottoFail() {
        assertThatExceptionOfType(MinimumAmountException.class)
                .isThrownBy(() -> lottoMachine.generateRandomLotto(Money.ZERO));
    }

    @DisplayName("로또 한장을 자동으로 구매한다")
    @Test
    void buyLottoSuccess() {
        Money money = Money.won(1000);

        List<Lotto> buyLottos = lottoMachine.generateRandomLotto(money);

        assertThat(buyLottos).hasSize(1);
    }

    @DisplayName("로또 두장을 자동으로 구매한다")
    @Test
    void buyManyLottoSuccess() {
        Money money = Money.won(2000);

        List<Lotto> buyLottos = lottoMachine.generateRandomLotto(money);

        assertThat(buyLottos).hasSize(2);
    }

    @DisplayName("로또 한장을 수동으로 구매한다")
    @Test
    void buyManualLotto() {
        List<String> numbersOfLotto = Arrays.asList("1,2,3,4,5,6");

        List<Lotto> buyLottos = lottoMachine.generateManualLotto(numbersOfLotto);

        assertThat(buyLottos).hasSize(1);
        assertThat(buyLottos).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 두장을 수동으로 구매한다")
    @Test
    void buyManyManualLotto() {
        List<String> numbersOfLotto = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");

        List<Lotto> buyLottos = lottoMachine.generateManualLotto(numbersOfLotto);

        assertThat(buyLottos).hasSize(2);
        assertThat(buyLottos).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6),
                        ofNumbers(2, 3, 4, 5, 6, 7));
    }

    @DisplayName("수동으로 2장, 자동으로 1장 구매한다")
    @Test
    void buyMultiLotto() {
        Money money = Money.won(3000);
        List<String> numbersOfLotto = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");

        List<Lotto> buyLottos = lottoMachine.buy(money, numbersOfLotto);

        assertThat(buyLottos).hasSize(3);
        assertThat(buyLottos).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6),
                        ofNumbers(2, 3, 4, 5, 6, 7));
    }
}