package lotto_tests;

import lotto.model.LottoBonusMatchResult;
import lotto.model.wrapper.LottoMatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.model.LottoBonusMatchResult.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 매칭 카운트 테스트")
public class LottoMatchCountTests {

    @DisplayName("로또 매칭 카운트 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases")
    public void generateLottoMatchCountTest(int matchCount, LottoBonusMatchResult lottoBonusMatchResult) {
        assertThatCode(() -> LottoMatchCount.newInstance(matchCount, lottoBonusMatchResult)).doesNotThrowAnyException();
    }

    @DisplayName("로또 매칭 카운트 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases2")
    public void generateLottoMatchCountTest2(int matchCount, boolean matchBonusNumber, LottoMatchCount lottoMatchCount) {
        assertThat(LottoMatchCount.create(matchCount, matchBonusNumber)).isEqualTo(lottoMatchCount);
    }

    private static Stream<Arguments> generateLottoMatchCountTestCases() {
        return Stream.of(
                Arguments.of(2, ANYWAY),
                Arguments.of(5, UN_MATCH),
                Arguments.of(5, MATCH),
                Arguments.of(6, ANYWAY)
        );
    }

    private static Stream<Arguments> generateLottoMatchCountTestCases2() {
        return Stream.of(
                Arguments.of(2, true, LottoMatchCount.newInstance(2, ANYWAY)),
                Arguments.of(5, true, LottoMatchCount.newInstance(5, MATCH)),
                Arguments.of(5, false, LottoMatchCount.newInstance(5, UN_MATCH)),
                Arguments.of(6, false, LottoMatchCount.newInstance(6, ANYWAY)));
    }
}
