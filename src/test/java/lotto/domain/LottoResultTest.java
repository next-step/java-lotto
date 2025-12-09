package lotto.domain;

import lotto.domain.constant.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @BeforeEach
    void init() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.putLottoResult(LottoRank.FOURTH);
    }

    @Test
    void 수익률_100퍼센트_미만() {
        double result = LottoResult.profitPercent(new LottoPrice(100000, 0));
        Assertions.assertThat(result).isEqualTo(0.5);
    }

   /* @Test
    void 수익률_100퍼센트_이상() {
        double result = LottoResult.profitPercent(new LottoPrice(50000));
        Assertions.assertThat(result).isEqualTo(1.0);
    }*/

}
