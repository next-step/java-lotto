package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @DisplayName("로또 순위 Enum테스트")
    @CsvSource(value = {"FIRST:6:false:2000000000", "SECOND:5:true:30000000", "THIRD:5:false:1500000", "FOURTH:4:false:50000", "FIFTH:3:false:5000", "MISS:0:false:0"}, delimiter = ':')
    public void lottoRankEnumCreate(String rankName, int matchCount, boolean hasBonusNumber, int reward) {
        LottoRank lottoRank = LottoRank.valueOf(rankName);
        assertThat(lottoRank).isEqualTo(LottoRank.of(matchCount, hasBonusNumber));
        assertThat(lottoRank.reward()).isEqualTo(reward);
        assertThat(lottoRank.matchCount()).isEqualTo(matchCount);
    }

}
