package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @ParameterizedTest(name = "로또 번호가 일치한 갯수에 따라 올바른 rank를 반환한다. 입력값: {0}")
    @MethodSource("provideLottoTestCases")
    void invalidNumberTest(Lotto purchased, Lotto winning, LottoRank expected) {
        LottoRank result = purchased.getRank(winning);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideLottoTestCases() {
        Lotto winningLotto = Lotto.create(List.of(1,2,3,4,5,6));
        return Stream.of(
                Arguments.of(Lotto.create(List.of(1,2,3,4,5,6)), winningLotto, LottoRank.FIRST),
                Arguments.of(Lotto.create(List.of(1,2,3,4,5,7)), winningLotto, LottoRank.SECOND),
                Arguments.of(Lotto.create(List.of(1,2,3,4,7,8)), winningLotto, LottoRank.THIRD),
                Arguments.of(Lotto.create(List.of(1,2,3,7,8,9)), winningLotto, LottoRank.FOURTH)
        );
    }
}
