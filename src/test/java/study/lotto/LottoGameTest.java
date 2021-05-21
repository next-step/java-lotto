package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void lottoGame(){
        lottoGame = new LottoGame();
    }


    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @Test
    public void purchaseableLottoTest(){
        //given
        BigDecimal paymentAmount = BigDecimal.valueOf(14000);

        int result = lottoGame.purchaseableLotto(paymentAmount);
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("입력한 금액만큼 로또를 구매한다")
    @Test
    public void purchaseTest(){
        //given
        BigDecimal paymentAmount = BigDecimal.valueOf(12000);

        PurchasedLotto result = lottoGame.purchase(paymentAmount);
        assertThat(result.values().size()).isEqualTo(12);
    }

    @DisplayName("당첨 번호를 생성한다")
    @Test
    public void winningNumbersTest(){
        lottoGame.draw();
        WinningNumbers winningNumbers = lottoGame.winningNumbers();
        List<Integer> numbers = winningNumbers.value();

        LottoNumbersTest.availableLottoNumbersTest(numbers);
    }


}
