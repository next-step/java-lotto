package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankCountTest {

    @DisplayName("findCount() 메소드는 당첨된 로또가 없으면 0을 반환한다")
    @Test
    void findCount_LottoRank_ZeroValue() {
        LottoRankCount lottoRankCount = LottoRankCount.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            assertThat(lottoRankCount.findCount(lottoRank)).isEqualTo(0);
        });
    }

    @DisplayName("plusCount() 메소드는 LottoRank의 당첨 개수를 1씩 증가시킨다")
    @Test
    void plusCount_LottoRank_IncreasedValue() {
        LottoRankCount lottoRankCount = LottoRankCount.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            lottoRankCount.plusCount(lottoRank);
            assertThat(lottoRankCount.findCount(lottoRank)).isEqualTo(1);

            lottoRankCount.plusCount(lottoRank);
            assertThat(lottoRankCount.findCount(lottoRank)).isEqualTo(2);
        });
    }
}
