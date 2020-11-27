package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine();
    }

    @DisplayName("최소구입금액보다 구입금액이 작으면 exception 이 발생한다")
    @Test
    void lessThenLottoPrice(){
        assertThatThrownBy( () -> lottoMachine.issueLottos(Lotto.PRICE - 1) )
                .isInstanceOf(NotPurchaseLottoException.class);
    }

    @DisplayName("최소구입금액보다 구입금액이 작으면 exception 이 발생한다 ( 수동로또 포함 )")
    @Test
    void lessThenLottoPrice2(){
        List<String> twoLottoNumber = Arrays.asList("1,2,3,4,5,6", "10,11,12,13,14,15");
        assertThatThrownBy( () -> lottoMachine.issueLottos(1000, twoLottoNumber ) )
                .isInstanceOf(NotPurchaseLottoException.class);
    }

    @DisplayName("로또 구입금액을 입력하면 금액만큼의 로또를 발급 해준다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "3000:3", "4000:4"}, delimiterString = ":")
    void buyLotto(int money, int expected) {
        assertThat(lottoMachine.issueLottos(money)).hasSize(expected);
    }

    @DisplayName("로또 구입금액과 수동번호 로또를 입력하면 수동번호 만큼을 제외한 나머지 금액만큼은 자동으로 로또를 발급해준다")
    @Test
    void buyLottoWithManualNumber(){
        List<Lotto> generated = lottoMachine.issueLottos(4000, Arrays.asList("1,2,3,4,5,6", "10,11,12,13,14,15"));

        assertThat(generated)
                .hasSize(4)
                .contains(new Lotto("1,2,3,4,5,6"), new Lotto("10,11,12,13,14,15"));

    }

    @DisplayName("당첨된 로또의 수익율을 알 수 있다")
    @Test
    void rateOfReturn() {
        Lotto secondPrizeLotto = new Lotto("1, 2, 3, 4, 5, 10");
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumbers, secondPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1500);
    }


    @DisplayName("2장이상 당첨된 로또의 수익율을 알 수 있다")
    @Test
    void rateOfReturn2() {
        Lotto firstPrizeLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto fouthPrizeLotto = new Lotto("1, 2, 3, 10, 20, 30");

        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumbers, firstPrizeLotto, fouthPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(1000002.5);
    }

    @DisplayName("당첨이 되지 않으면 수익률은 0 이다")
    @Test
    void rateOfReturn3() {
        Lotto noPrizeLotto = new Lotto("30, 31, 32, 33, 34, 35");
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumbers, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(0);
    }

    @DisplayName("당첨금과 로또구입금액이 같으면 수익률은 1 이다")
    @Test
    void rateOfReturn4() {
        Lotto fourthPrizeLotto = new Lotto("1, 2, 3, 10, 20, 30");
        Lotto noPrizeLotto = new Lotto("11, 12, 13, 10, 20, 30");

        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6",7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumbers, fourthPrizeLotto, noPrizeLotto);

        assertThat(result.getRateOfReturn()).isEqualTo(2.5);
    }

    @DisplayName("2등 당첨된 로또는 3등에서 제외된다")
    @Test
    void prizeWinning(){
        Lotto secondPrizeLotto = new Lotto("1,2,3,4,5,7");
        Lotto thirdPrizeLotto = new Lotto("1,2,3,4,5,8");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 7);

        PrizeWinningResult result = lottoMachine.checkPrizeWinning(winningNumbers, secondPrizeLotto, thirdPrizeLotto);

        assertThat(result.getRankedLottoCount(LottoRanking.SECOND)).isEqualTo(1);
        assertThat(result.getRankedLottoCount(LottoRanking.THIRD)).isEqualTo(1);
    }

}
