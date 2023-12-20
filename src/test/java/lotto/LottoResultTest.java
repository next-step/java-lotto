package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

class LottoResultTest {

    @Test
    @DisplayName("수익률을 정확히 계산하는지 확인한다.")
    void test1() {
        int totalPriceToBuyLotto = 1000;
        LottoNumbers toTestLottoNumber = new LottoNumbers("1,2,3,4,5,6");
        LottoNumbers winningNumber = new LottoNumbers("1,2,3,4,5,6");
        LottoTicket lottoTicket = new LottoTicket(toTestLottoNumber);
        LottoResult lottoResult = new LottoResult(lottoTicket, winningNumber);
        float expectingResult = 2000000;

        assertThat(lottoResult.calculateRateOfReturn(totalPriceToBuyLotto)).isEqualTo(expectingResult);
    }
}

