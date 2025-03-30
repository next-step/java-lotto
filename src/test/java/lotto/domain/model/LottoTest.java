package lotto.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @ParameterizedTest(name = "로또 번호가 일치한 갯수에 따라 올바른 rank를 반환한다. 입력값: {0}")
    @MethodSource("provideLottoTestCases")
    void lottoRankTest(Lotto purchased, WinningLotto winning, LottoRank expected) {
        LottoRank result = winning.calculateRank(purchased);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideLottoTestCases() {
        WinningLotto winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6), 7);
        return Stream.of(
                Arguments.of(Lotto.createManual(List.of(1,2,3,4,5,6)), winningLotto, LottoRank.FIRST),
                Arguments.of(Lotto.createManual(List.of(1,2,3,4,5,7)), winningLotto, LottoRank.SECOND),
                Arguments.of(Lotto.createManual(List.of(1,2,3,4,5,8)), winningLotto, LottoRank.THIRD),
                Arguments.of(Lotto.createManual(List.of(1,2,3,4,7,9)), winningLotto, LottoRank.FOURTH),
                Arguments.of(Lotto.createManual(List.of(1,2,3,4,8,9)), winningLotto, LottoRank.FOURTH)
        );
    }
}
