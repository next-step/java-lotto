package lotto;

import lotto.domain.Fee;
import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoRanksTest {

    @Test
    @DisplayName("수익률 산출")
    void 수익률_산출() {
        LottoRanks lottoRanks = new LottoRanks(List.of(LottoRank.THIRD, LottoRank.FOURTH), new Fee(2000));
        float margin = lottoRanks.getMargin();
        assertThat(margin).isEqualTo((float) 55000 /2000);
    }
}
