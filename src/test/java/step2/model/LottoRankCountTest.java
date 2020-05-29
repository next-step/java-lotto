package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankCountTest {

    @DisplayName("로또 등수별 증가된 카운트를 조회 할 수 있다.")
    @Test
    void findCount_LottoRank_CountValue() {
        LottoRankCount lottoRankCount = LottoRankCount.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            lottoRankCount.plusCount(lottoRank);
            assertThat(lottoRankCount.findCount(lottoRank)).isEqualTo(1);
        });
    }
}
