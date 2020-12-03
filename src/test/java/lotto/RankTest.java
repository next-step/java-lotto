package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {


    @ParameterizedTest
    @CsvSource(value = {"6:FIRST","5:THIRD","4:FOURTH","3:FIFTH"}, delimiter = ':')
    public void getRankByMatchCnt(int matchCnt, String rankName) {
        assertThat(Rank.valueOf(matchCnt, false).name()).isEqualTo(rankName);

    }

    @ParameterizedTest
    @CsvSource(value = {"5:SECOND"}, delimiter = ':')
    public void getRankByMatchBonus(int matchCnt, String rankName) {
        assertThat(Rank.valueOf(matchCnt, true).name()).isEqualTo(rankName);

    }
}
