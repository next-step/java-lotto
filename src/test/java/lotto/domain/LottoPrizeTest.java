package lotto.domain;

import lotto.domain.util.LottoTestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest(name = LottoTestUtils.PARAMETRIZED_TEST_NAME)
    @CsvSource(value = {
            "NOTHING,7/8/9/10/11/12",
            "THREE_SAME,4/5/6/7/8/9",
            "SIX_SAME,1/2/3/4/5/6"
    })
    void of(LottoPrize lottoPrize, String numbers) {
        List<LottoNumber> integers = LottoTestUtils.lottoNumbers(numbers);
        LottoTicket lottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);
        LottoTicket targetLottoTicket = LottoTicket.customLottoTicket(integers);

        assertThat(LottoPrize.of(lottoTicket, targetLottoTicket))
                .isEqualTo(lottoPrize);
    }
}
