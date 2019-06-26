package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoStoreTest {
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1500,1", "0,0", "900,0", "2000,2"})
    void 로또_구매(int input, int expected) {
        LottoStore lottoStore = new LottoStore();

        assertThat(lottoStore.buyLotto(input).getLottoTickets()).size().isEqualTo(expected);
    }
}
