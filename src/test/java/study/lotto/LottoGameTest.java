package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.*;
import study.lotto.util.LottoNumberGenerator;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        lottoGame = new LottoGame(inputView, resultView);
    }


    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @ParameterizedTest
    @CsvSource({"14000,14", "2000,2", "1500,1", "400,0"})
    public void purchaseableLottoTest(BigDecimal purchaseAmount, int expected) {

        assertThat(lottoGame.purchaseableNumber(purchaseAmount)).isEqualTo(expected);
    }


    @DisplayName("구매 금액만큼 로또장수가 구매된다")
    @ParameterizedTest
    @CsvSource({"14000,14", "2000,2", "1500,1", "400,0"})
    public void purchaseTest(BigDecimal purchaseAmount, int expected) {
        PurchasedLottos purchasedLottos = lottoGame.purchase(purchaseAmount);
        assertThat(purchasedLottos.count()).isEqualTo(expected);

    }


    @DisplayName("당첨개수 확인")
    @Test
    public void checkPrizeTest() {
        //given
        PurchasedLottos purchasedLottos = new PurchasedLottos(generatePurchaseLottos());
        LottoNumbers winningNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,4,5,6"));

        //when
        WinningResult winningResult = lottoGame.checkPrize(purchasedLottos, winningNumbers);

        //then
        assertThat(winningResult.value().get(WinningPrize.FIRST)).isEqualTo(1);
        assertThat(winningResult.value().get(WinningPrize.SECOND)).isEqualTo(0);
        assertThat(winningResult.value().get(WinningPrize.THIRD)).isEqualTo(1);
        assertThat(winningResult.value().get(WinningPrize.FOURTH)).isEqualTo(2);
    }

    private List<LottoNumbers> generatePurchaseLottos() {
        List<LottoNumbers> PurchasedLottos = new ArrayList<>();
        PurchasedLottos.add(new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,4,5,6")));
        PurchasedLottos.add(new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,4,15,16")));
        PurchasedLottos.add(new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,14,15,16")));
        PurchasedLottos.add(new LottoNumbers(LottoNumberGenerator.markedNumbers("1,12,3,14,15,6")));
        return PurchasedLottos;
    }

    @DisplayName("수익률 확인")
    @ParameterizedTest
    @CsvSource({"0,0.00", "5000,1.00", "55000,11.00"})
    public void profitRateTest(BigDecimal prizeAmount, BigDecimal expect) {

        assertThat(lottoGame.profitRate(BigDecimal.valueOf(5000),prizeAmount)).isEqualTo(expect);
    }

}
