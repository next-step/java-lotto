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
    @CsvSource(value = {"6:FIRST","5:SECOND","4:THIRD","3:FOURTH","2:FIFTH","1:LOSEONE","0:LOSEZERO"}, delimiter = ':')
    public void getRankByMatchCnt(int matchCnt, String rankName) {
        assertThat(Rank.getRankByMatchCnt(matchCnt).name()).isEqualTo(rankName);

    }

}
