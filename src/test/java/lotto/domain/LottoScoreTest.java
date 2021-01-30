package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoScoreTest {
    private static Stream<Arguments> providerCalculateScoreParams() {
        return Stream.of(
            Arguments.of(6, false, LottoScore.FIRST),
            Arguments.of(5, true, LottoScore.SECOND),
            Arguments.of(5, false, LottoScore.THIRD),
            Arguments.of(4, false, LottoScore.FOURTH),
            Arguments.of(4, true, LottoScore.FOURTH),
            Arguments.of(3, false, LottoScore.FIFTH),
            Arguments.of(3, true, LottoScore.FIFTH),
            Arguments.of(2, false, LottoScore.NOTHING)
        );
    }

    @DisplayName("일치 개수와 보너스 번호 일치에 따라 스코어를 잘 계산하는지 확인")
    @ParameterizedTest
    @MethodSource("providerCalculateScoreParams")
    void calculateScore(int matchedCnt, boolean isBounsMatched, LottoScore score) {
        assertEquals(LottoScore.calculateScore(matchedCnt, isBounsMatched), score);
    }
}