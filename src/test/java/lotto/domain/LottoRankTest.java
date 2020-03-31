package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("로또 랭크는 로또 당첨에 대한 사전 정보를 확인 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 51, 6})
    public void getLottoRankInfoTest(int matchCount) {
        LottoRank lottoRank = LottoRank.of(matchCount);

        assertThat(lottoRank.getMatchCount()).isEqualTo(matchCount);
    }

}
