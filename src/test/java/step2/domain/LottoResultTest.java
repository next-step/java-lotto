package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.helper.LottoHelper.makeLottoNumbersHelper;

class LottoResultTest {
    private int bonus;

    @Test
    void getResult_결과만들기() {
        List<LottoNumber> lottoNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        bonus = 45;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 11, 22, 33, bonus));

        LottoResult lottoResult = new LottoResult(winningNumbers, Collections.singletonList(lottoTicket));

        assertThat(lottoResult.getResult().get(PriceGroup.THREE)).isEqualTo(1);
    }

    @Test
    void getRate_이율_구하기() {
        List<LottoNumber> lottoNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        bonus = 45;
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 11, 22, 33, bonus));

        LottoResult lottoResult = new LottoResult(winningNumbers, Arrays.asList(lottoTicket));

        assertThat(lottoResult.getRate()).isEqualTo(5000L / 1000D);
    }
}