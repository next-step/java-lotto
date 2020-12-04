package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameResultTest {

    private static final WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 8, 9", 7);
    private Lottoes lottoes = new Lottoes(new PurchaseAmount(1000), Arrays.asList("1, 2, 3, 4, 5, 6"));

    @Test
    @DisplayName("1개의 lotto를 구매하고 4등이 일 때, 수익률을 계산한다.")
    void should_return_rate_of_return() {
        //Given
        LottoGameResult result = lottoes.getResult(winningNumbers);

        //When
        double rateOfReturn = result.getRateOfReturn();

        //Then
        assertThat(rateOfReturn).isEqualTo(50);
    }

    @Test
    @DisplayName("1개의 lotto를 구매하고 4등이 일 때")
    void should_return_rank() {
        //Given
        LottoGameResult result = lottoes.getResult(winningNumbers);

        //When
        Map<Rank, Integer> ranks = result.getRanks();

        //Then
        assertThat(ranks.get(Rank.FOURTH)).isOne();
    }
}
