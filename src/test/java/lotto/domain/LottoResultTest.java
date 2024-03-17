package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    @DisplayName("addCorrectLottoCount 호출하면 매개변수에 로또 하나 당 맞춘 개수가 넘어가고 해당하는 변수 가산")
    void addCorrectLottoCount() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addCorrectLottoCount(2);

        lottoResult.addCorrectLottoCount(3);

        lottoResult.addCorrectLottoCount(4);
        lottoResult.addCorrectLottoCount(4);

        lottoResult.addCorrectLottoCount(5);
        lottoResult.addCorrectLottoCount(5);

        lottoResult.addCorrectLottoCount(6);

    }

    @Test
    @DisplayName("rateOfReturn 호출 시 수익률을 소숫점 이하 2자리로 반환")
    void rateOfReturn() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addCorrectLottoCount(3);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(5);
    }
}
