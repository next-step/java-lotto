package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.Operand;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("일치 개수를 입력하면 로또 등수를 반환한다.")
    @MethodSource("provideLottoRankForFindRank")
    @ParameterizedTest
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

    @DisplayName("일치 개수가 3~6개가 아니면 MISS 타입을 반환한다")
    @MethodSource("provideLottoRankForFindRank")
    @ParameterizedTest
    void findRank_NotWinningCount_LottoRankMiss() {
        IntStream.rangeClosed(7, 50).forEach(matchCount -> {
            LottoRank lottoRank = LottoRank.findRank(matchCount);
            assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        });

        IntStream.rangeClosed(1, 2).forEach(matchCount -> {
            LottoRank lottoRank = LottoRank.findRank(matchCount);
            assertThat(lottoRank).isEqualTo(LottoRank.MISS);
        });
    }

    @DisplayName("로또 우승 상금은 0보다 크거나 같다.")
    @Test
    void getWinningMoney__WinningMoney() {
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            assertThat(lottoRank.getWinningMoney()).isGreaterThanOrEqualTo(0);
        });
    }
}
