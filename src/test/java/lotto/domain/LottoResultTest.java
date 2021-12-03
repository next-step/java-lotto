package lotto.domain;

import lotto.domain.util.LottoUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {
            "SIX_SAME,1/2/3/4/5/6",
            "THREE_SAME,4/5/6/7/8/9",
            "NOTHING,7/8/9/10/11/12"
    })
    void lottoPrizeCount(LottoPrize lottoPrize, String numbers) {
        LottoPrice lottoPrice = new LottoPrice(3000);
        List<LottoNumber> lottoNumbers = LottoUtils.lottoNumbers(numbers);
        List<LottoTicket> lottoTickets = Collections.singletonList(
                LottoTicket.customLottoTicket(lottoNumbers));

        MyLottoTickets myLottoTickets = new MyLottoTickets(lottoPrice, lottoTickets);
        LottoTicket winnerLottoTicket = LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6);

        LottoResult lottoResult = new LottoResult(myLottoTickets, winnerLottoTicket);
        lottoResult.countPrize();

        assertThat(lottoResult.lottoPrizeCount(lottoPrize))
                .isEqualTo(1);
    }
}
