package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultRankTest {

    @ParameterizedTest
    @CsvSource(value = {
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
    public void rankValueOf(int matchCount, boolean matchBonus, ResultRank resultRank) {
        assertThat(ResultRank.valueOf(matchCount, matchBonus)).isEqualTo(resultRank);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,true",
            "-1,false",
            "7,true",
            "7,false",
    })
    public void rankValueOf_failed(int matchCount, boolean matchBonus) {
        assertThatThrownBy(() -> {
            ResultRank.valueOf(matchCount, matchBonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }
}
