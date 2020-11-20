package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;
    List<Integer> prizeMoneys;

    @BeforeEach
    void setUp() {
        this.prizeMoneys = Arrays.asList(2000000000, 1500000, 50000, 2000);
        this.lottoMachine = new LottoMachine(this.prizeMoneys);
    }

    @DisplayName("로또 구입금액을 입력하면 금액만큼의 로또를 발급 해준다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "3000:3", "4000:4"}, delimiterString = ":")
    void buyLotto(int money, int expected) {
        assertThat(this.lottoMachine.issue(money)).hasSize(expected);
    }

    @DisplayName("당첨된 로또의 수익율을 알 수 있다")
    @Test
    void rateOfReturn() {
        Lotto secondPrizeLotto = myLotto(1, 2, 3, 4, 5, 10);
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, secondPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1500);
    }


    @DisplayName("2장이상 당첨된 로또의 수익율을 알 수 있다")
    @Test
    void rateOfReturn2() {
        Lotto firstPrizeLotto = myLotto(1, 2, 3, 4, 5, 6);
        Lotto fouthPrizeLotto = myLotto(1, 2, 3, 10, 20, 30);

        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, firstPrizeLotto, fouthPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1000001.0);
    }

    @DisplayName("당첨이 되지 않으면 수익률은 0 이다")
    @Test
    void rateOfReturn3() {
        Lotto noPrizeLotto = myLotto(30, 31, 32, 33, 34, 35);
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(0);
    }

    @DisplayName("당첨금과 로또구입금액이 같으면 수익률은 1 이다")
    @Test
    void rateOfReturn4() {
        Lotto fourthPrizeLotto = myLotto(1, 2, 3, 10, 20, 30);
        Lotto noPrizeLotto = myLotto(11, 12, 13, 10, 20, 30);

        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, fourthPrizeLotto, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1);
    }


    private Lotto myLotto(int i, int i1, int i2, int i3, int i4, int i5) {
        return new Lotto(new LottoNumber(Arrays.asList(i, i1, i2, i3, i4, i5)));
    }
}
