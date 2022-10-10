package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCompanyTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:2", "3:2", "4:0", "5:0", "6:0"}, delimiter = ':')
    void getLottoResult(int rank, int expected) {
        LottoWallet lottoWallet = new LottoWallet(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)),
                new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)),
                new Lotto(Arrays.asList(1, 2, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(1, 2, 13, 14, 15, 16))
        ));

        LottoResult lottoResult = LottoCompany.createLottoResult(Arrays.asList(1, 2, 3, 4, 5, 6), lottoWallet);
        assertThat(lottoResult.getWonAmountOf(rank)).isEqualTo(expected);
    }
}
