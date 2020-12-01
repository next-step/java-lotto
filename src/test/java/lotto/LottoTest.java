package lotto;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static LottoSimulator lottoSimulator;

    @BeforeAll
    public static void init() {
        lottoSimulator = new LottoSimulator(new SequentialLottoNumberGenerator());
    }

    @Test
    public void winFirstPlaceAndMiss() {
        final int COST = 2000;

        // will buy 1,2,3,4,5,6 and 7,8,9,10,11,12
        List<LottoGame> boughtLottoGames = lottoSimulator.buy(COST);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoResult result = lottoSimulator.getWinnerResult(winningNumbers);

        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_6)).isEqualTo(1);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_5)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_4)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_3)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_NONE)).isEqualTo(1);

        assertThat(result.getProfitRatio())
                .isCloseTo(LottoPlace.MATCHED_6.getPrize() / COST, Percentage.withPercentage(1));
    }

}
