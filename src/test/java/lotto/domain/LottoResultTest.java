package lotto.domain;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {



    @Test
    @DisplayName("수익률 산출")
    void 수익률_산출() {
        LottoResult lottoResult = new LottoResult(List.of(LottoRank.FOURTH));
        float margin = lottoResult.getMargin(2000);
        assertThat(margin).isEqualTo((float) LottoRank.FOURTH.prizeMoney() /2000);
    }
}
