package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameResultTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {

        //TODO 좀 더 테스트하기 쉬운 구조로 짤수 있지 않을까?
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottoes lottoes = new Lottoes(Arrays.asList(lottoNumbers));
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 7, 8, 9");

        lottoGame = new LottoGame(lottoes, winningNumber);
    }


    @Test
    @DisplayName("14,000원의 lotto를 구매하고 3등이 1개일 때, 수익률을 계산한다.")
    void should_return_winning_lotto() {
        //Given
        LottoGameResult result = lottoGame.getResult();

        //When
        double rateOfReturn = result.getRateOfReturn(new PurchaseAmount(14000));

        //Then
        assertThat(rateOfReturn).isEqualTo(0.35);
    }
}
