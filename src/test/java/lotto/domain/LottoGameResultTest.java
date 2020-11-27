package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameResultTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {

        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        Lottoes lottoes = new Lottoes(Arrays.asList(lottoNumbers));
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 7, 8, 9");

        lottoGame = new LottoGame(lottoes, winningNumbers);
    }


    @Test
    @DisplayName("1개의 lotto를 구매하고 4등이 일 때, 수익률을 계산한다.")
    void should_return_rate_of_return() {
        //Given
        LottoGameResult result = lottoGame.getResult();

        //When
        double rateOfReturn = result.getRateOfReturn();

        //Then
        assertThat(rateOfReturn).isEqualTo(5);
    }

    @Test
    @DisplayName("1개의 lotto를 구매하고 4등이 일 때")
    void should_return_rank() {
        //Given
        LottoGameResult result = lottoGame.getResult();

        //When
        Map<Rank, Integer> ranks = result.getRanks();

        //Then
        assertThat(ranks.get(Rank.FOURTH)).isEqualTo(1);
    }
}
