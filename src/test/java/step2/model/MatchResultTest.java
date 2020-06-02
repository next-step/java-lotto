package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @DisplayName("findResult() 메소드는 당첨된 로또가 없으면 0을 반환한다")
    @Test
    void findResult_LottoRank_ZeroValue() {
        MatchResult matchResult = MatchResult.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(0);
        });
    }

    @DisplayName("plusCount() 메소드는 LottoRank의 당첨 개수를 1씩 증가시킨다")
    @Test
    void plusCount_LottoRank_IncreasedValue() {
        MatchResult matchResult = MatchResult.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            matchResult.plusCount(lottoRank);
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(1);

            matchResult.plusCount(lottoRank);
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(2);
        });
    }
}
