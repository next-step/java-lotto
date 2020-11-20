package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine();
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
        Lotto secondPrizeLotto = LottoUtils.lotto("1, 2, 3, 4, 5, 10");
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, secondPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1500);
    }


    @DisplayName("2장이상 당첨된 로또의 수익율을 알 수 있다")
    @Test
    void rateOfReturn2() {
        Lotto firstPrizeLotto = LottoUtils.lotto("1, 2, 3, 4, 5, 6");
        Lotto fouthPrizeLotto = LottoUtils.lotto("1, 2, 3, 10, 20, 30");

        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6",7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, firstPrizeLotto, fouthPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1000002.5);
    }

    @DisplayName("당첨이 되지 않으면 수익률은 0 이다")
    @Test
    void rateOfReturn3() {
        Lotto noPrizeLotto = LottoUtils.lotto("30, 31, 32, 33, 34, 35");
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(0);
    }

    @DisplayName("당첨금과 로또구입금액이 같으면 수익률은 1 이다")
    @Test
    void rateOfReturn4() {
        Lotto fourthPrizeLotto = LottoUtils.lotto("1, 2, 3, 10, 20, 30");
        Lotto noPrizeLotto = LottoUtils.lotto("11, 12, 13, 10, 20, 30");

        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6",7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, fourthPrizeLotto, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(2.5);
    }

    @DisplayName("2등 당첨된 로또는 3등에서 제외된다")
    @Test
    void prizeWinning(){
        Lotto secondPrizeLotto = LottoUtils.lotto("1,2,3,4,5,7");
        Lotto thirdPrizeLotto = LottoUtils.lotto("1,2,3,4,5,8");
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1,2,3,4,5,6), 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumber, secondPrizeLotto, thirdPrizeLotto);

        assertThat(result.getRankedLottoCount(LottoRanking.SECOND)).isEqualTo(1);
        assertThat(result.getRankedLottoCount(LottoRanking.THIRD)).isEqualTo(1);
    }
}
