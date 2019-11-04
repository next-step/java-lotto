package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("lank 카운트를 하나씩 올리고 실제로 올라갔는지 확인한다.")
    void update() {
        LottoResult lottoResult = new LottoResult();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.update(lottoRank.getCount());
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            assertThat(lottoResult.rankCount(lottoRank)).isEqualTo(1);
        }
    }
}
