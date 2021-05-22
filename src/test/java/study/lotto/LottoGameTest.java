package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @Test
    public void purchaseableLottoTest(){
        //given
        LottoGame lottoGame = new LottoGame();
        BigDecimal paymentAmount = BigDecimal.valueOf(14000);

        int result = lottoGame.purchaseableLotto(paymentAmount);
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("입력한 금액만큼 로또를 구매한다")
    @Test
    public void purchaseTest(){
        //given
        LottoGame lottoGame = new LottoGame();
        BigDecimal paymentAmount = BigDecimal.valueOf(12000);

        lottoGame.purchase(paymentAmount);
        PurchasedLottos result = lottoGame.purchasedLotto();
        assertThat(result.values().size()).isEqualTo(12);
    }

    @DisplayName("당첨 번호를 생성한다")
    @Test
    public void winningNumbersTest(){
        LottoGame lottoGame = new LottoGame();
        lottoGame.draw();
        WinningNumbers winningNumbers = lottoGame.winningNumbers();
        List<Integer> numbers = winningNumbers.value();

        LottoNumbersTest.availableLottoNumbersTest(numbers);
    }

    @DisplayName("당첨 확인")
    @Test
    public void winningCheck(){
        LottoGame lottoGame = gameSet();
        lottoGame.checkPrize();
        WinningLottos lottoPrize = lottoGame.winningLottos();
        assertThat(lottoPrize.prizeCount(3)).isEqualTo(2);
        assertThat(lottoPrize.prizeCount(4)).isEqualTo(1);
        assertThat(lottoPrize.prizeCount(5)).isEqualTo(1);
        assertThat(lottoPrize.prizeCount(6)).isEqualTo(1);
    }

    private LottoGame gameSet() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1,2,3,4,5,6));

        List<LottoPaper> lottoPapers = new ArrayList<>();
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,3,4,5,6)));
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,3,4,5,16)));
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,3,4,15,16)));
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,3,14,15,16)));
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,6,34,35,42)));
        lottoPapers.add(new LottoPaper(Arrays.asList(1,2,16,34,35,42)));

        PurchasedLottos purchasedLottos = new PurchasedLottos(lottoPapers);
        return new LottoGame(winningNumbers, purchasedLottos);
    }


}
