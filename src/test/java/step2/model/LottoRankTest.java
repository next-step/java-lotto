package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.Operand;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("findRank() 메소드는 일치 개수를 입력하면 로또 등수를 반환한다.")
    @MethodSource("provideLottoRankForFindRank")
    @ParameterizedTest(name = "일치 개수가 ''{0}''이면 로또 등수는 ''{1}''이다")
    void findRank_MatchCount_LottoRank(int matchCount, LottoRank expectedRank) {
        LottoRank lottoRank = LottoRank.findRank(matchCount);
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoRankForFindRank() {
        return Stream.of(
                Arguments.of(1, LottoRank.MISS),
                Arguments.of(2, LottoRank.MISS),
                Arguments.of(3, LottoRank.FOURTH),
                Arguments.of(4, LottoRank.THIRD),
                Arguments.of(5, LottoRank.SECOND),
                Arguments.of(6, LottoRank.FIRST)
        );
    }

    @DisplayName("findRank() 메소드는 일치 개수가 3 ~ 6이 아니면 MISS를 반환한다")
    @ValueSource(ints = {2, 7})
    @ParameterizedTest
    void findRank_NotWinningCount_LottoRankMiss(int matchCount) {
        LottoRank lottoRank = LottoRank.findRank(matchCount);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }

    @DisplayName("getWinningMoney() 메소드의 반환 값은 0보다 크거나 같다.")
    @MethodSource("provideLottoRankForGetWinningMoney")
    @ParameterizedTest(name = "로또 등수가 ''{0}''이면 우승 상금은 ''{1}''원 이다")
    void getWinningMoney_None_WinningMoney(LottoRank lottoRank, int expectedWiningMoney) {
        assertThat(lottoRank.getWinningMoney()).isGreaterThanOrEqualTo(expectedWiningMoney);
    }

    private static Stream<Arguments> provideLottoRankForGetWinningMoney() {
        return Stream.of(
                Arguments.of(LottoRank.MISS, 0),
                Arguments.of(LottoRank.FOURTH, 5_000),
                Arguments.of(LottoRank.THIRD, 50_000),
                Arguments.of(LottoRank.SECOND, 1_500_000),
                Arguments.of(LottoRank.FIRST, 2_000_000_000)
        );
    }
}
