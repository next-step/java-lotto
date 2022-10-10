package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @DisplayName("번호 일치 개수와 보너스 번호 일치 여부에 맞는 로또 등수를 가져와야 한다.")
    @ParameterizedTest
    @CsvSource({
            "6,true,FIRST",
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "4,false,FOURTH",
            "3,true,FIFTH",
            "3,false,FIFTH",
            "2,true,NONE",
            "2,false,NONE",
            "1,true,NONE",
            "1,false,NONE",
            "0,true,NONE",
            "0,false,NONE",
    })
    void of(int matchNumber, boolean bonusMatched, LottoRank expected) {
        assertThat(LottoRank.of(matchNumber, bonusMatched)).isEqualTo(expected);
    }

    @DisplayName("상금이 있는 로또 등수 목록을 높은 등수 순으로 가져와야 한다.")
    @Test
    void getRewardRanks() {
        assertThat(LottoRank.getRewardRanks())
                .containsExactly(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH);
    }

    @DisplayName("상금이 있는 로또 등수 목록을 낮은 등수 순으로 가져와야 한다.")
    @Test
    void getRewardRanksReversed() {
        assertThat(LottoRank.getRewardRanksReversed())
                .containsExactly(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);
    }

}
