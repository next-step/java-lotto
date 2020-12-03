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
    private Lottoes lottoes;

    @BeforeEach
    void setUp() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        lottoes = new Lottoes(Arrays.asList(lottoNumbers));
    }


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
