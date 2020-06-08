package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    @DisplayName("당첨된 로또가 없으면 0을 반환")
    @Test
    void findResult() {
        MatchResult matchResult = MatchResult.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(0);
        });
    }

    @DisplayName("로또 등수에 해당하는 당첨 개수를 1씩 증가")
    @Test
    void plusCount() {
        MatchResult matchResult = MatchResult.create();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            matchResult.plusCount(lottoRank);
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(1);

            matchResult.plusCount(lottoRank);
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(2);
        });
    }
}
