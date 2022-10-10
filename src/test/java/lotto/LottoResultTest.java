package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();

        lottoResult.setPrizeOf(3, 5000);
        lottoResult.setPrizeOf(4, 50000);
        lottoResult.setPrizeOf(5, 1500000);
        lottoResult.setPrizeOf(6, 2000000000);

        lottoResult.setWonAmountOf(3, 1);
        lottoResult.setWonAmountOf(4, 2);
        lottoResult.setWonAmountOf(5, 0);
        lottoResult.setWonAmountOf(6, 0);

        lottoResult.setTotalAmounts(15);
        lottoResult.setLottoPrice(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getPrizeOf(int rank, int expectedPrize) {
        assertThat(lottoResult.getPrizeOf(rank)).isEqualTo(expectedPrize);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:2", "5:0", "6:0"}, delimiter = ':')
    void getWonAmountsOf(int rank, int expectedWonAmount) {
        assertThat(lottoResult.getWonAmountOf(rank)).isEqualTo(expectedWonAmount);
    }

    @Test
    void getReturnRate() {
        assertThat(lottoResult.getReturnRate()).isEqualTo(7);
    }

}
