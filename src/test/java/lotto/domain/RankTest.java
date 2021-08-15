package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest(name = "당첨 숫자 수와 보너스 볼 매치 여부에 따른 Rank 를 반환한다.")
    @CsvSource(value = {"0,false,MISS","1,false,MISS","2,false,MISS","3,false,FIFTH","4,false,FOURTH","5,false,THIRD","5,true,SECOND","6,false,FIRST"})
    public void MatchCountOfTest(int countOfMatch, boolean hitBonusBall, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch, hitBonusBall))
                .isEqualTo(rank);
    }

}