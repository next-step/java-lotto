package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.LottoMakeNumbers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoWinningTest {

    private static final LottoNumber BONUS_NUMBER = LottoNumber.of(7);

    @DisplayName("로또의 랭킹을 검증하는 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningLottoAndLottoRank")
    void 로또_랭킹_테스트(LottoWinning winningLotto, Lotto lotto, LottoRank expected) {
        assertEquals(expected, winningLotto.getRankOfLotto(lotto));
    }

    private static Stream<Arguments> provideWinningLottoAndLottoRank() {
        final LottoWinning winningLotto = LottoWinning.of(
                Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")),
                BONUS_NUMBER
        );
        return Stream.of(
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")), LottoRank.MATCH_SIX),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")), LottoRank.MATCH_BONUS),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,8")), LottoRank.MATCH_FIVE),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,8,7")), LottoRank.MATCH_FOUR),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,9,8,7")), LottoRank.MATCH_THREE),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,13,14,15,16")), LottoRank.MISS),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,12,13,14,15,16")), LottoRank.MISS),
                Arguments.of(winningLotto, Lotto.of(LottoMakeNumbers.convertStringToNumbers("11,12,13,14,15,16")), LottoRank.MISS)
        );
    }
}