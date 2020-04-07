package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("로또 랭크는 로또 당첨에 대한 사전 정보를 확인 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"0 : false", "1 : false", "2 : false", "3 : false", "4 : false",
            "5 : false", "5 : true", "6 : false"}, delimiter = ':')
    public void getLottoRankInfoTest(int matchCount, boolean bonus) {
        LottoRank lottoRank = LottoRank.of(LottoTier.of(matchCount, bonus));

        assertThat(lottoRank.getMatchCount()).isEqualTo(matchCount);
    }

}
