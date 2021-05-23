package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @DisplayName("로또 순위 Enum테스트")
    @CsvSource(value = {"FIRST:6:2000000000","SECOND:5:1500000","THIRD:4:50000","FOURTH:3:5000","MISS:0:0"}, delimiter = ':')
    public void lottoRankEnumCreate (String rankName, int matchCount, int reward) {
        LottoRank lottoRank = LottoRank.valueOf(rankName);
        assertThat(lottoRank).isEqualTo(LottoRank.of(matchCount));
        assertThat(lottoRank.reward()).isEqualTo(reward);
        assertThat(lottoRank.matchCount()).isEqualTo(matchCount);
    }

}
