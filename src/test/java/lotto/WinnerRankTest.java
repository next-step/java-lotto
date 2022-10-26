package lotto;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerRankTest {

    static Stream<Arguments> valueOfArguments(){
        return Stream.of(
                Arguments.of(new WinnerRankCondition(0, false), WinnerRank.MISS),
                Arguments.of(new WinnerRankCondition(1, false), WinnerRank.MISS),
                Arguments.of(new WinnerRankCondition(2, false), WinnerRank.MISS),
                Arguments.of(new WinnerRankCondition(3, false), WinnerRank.FIFTH),
                Arguments.of(new WinnerRankCondition(4, false), WinnerRank.FORTH),
                Arguments.of(new WinnerRankCondition(5, false), WinnerRank.THIRD),
                Arguments.of(new WinnerRankCondition(5, true), WinnerRank.SECOND),
                Arguments.of(new WinnerRankCondition(6, false), WinnerRank.FIRST)
        );
    }

    @DisplayName("WinnerCondtion 전달시 WinnerRank 반환한다.")
    @ParameterizedTest
    @MethodSource("valueOfArguments")
    void testIfGetValidWinnerRank(WinnerRankCondition winnerRankCondition, WinnerRank winnerRank){
        assertThat(WinnerRank.valueOf(winnerRankCondition)).isEqualTo(winnerRank);
    }

}
