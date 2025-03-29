package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value =  {
        "6,true,FIRST",
        "6,false,FIRST",
        "5,true,SECOND",
        "5,false,THIRD",
        "4,true,FOURTH",
        "4,false,FOURTH",
        "3,true,FIFTH",
        "3,false,FIFTH",
        "2,true,NO_RANK",
        "2,false,NO_RANK",
        "1,true,NO_RANK",
        "1,false,NO_RANK",
        "0,true,NO_RANK",
        "0,false,NO_RANK"})
    void findRankTest(int matchCount, boolean bonusMatch, LottoRank rank) {
        assertThat(LottoRank.findRank(matchCount, bonusMatch)).isEqualTo(rank);
    }

}
