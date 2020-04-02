package lottotests;

import lotto.model.LottoBonusMatchResult;
import lotto.model.wrapper.LottoResultMatchId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.model.LottoBonusMatchResult.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 매칭 식별자 테스트")
public class LottoResultMatchIdTests {

    @DisplayName("로또 매칭 식별자 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases")
    public void generateLottoMatchCountTest(int matchCount, LottoBonusMatchResult lottoBonusMatchResult) {
        assertThatCode(() -> LottoResultMatchId.newInstance(matchCount, lottoBonusMatchResult)).doesNotThrowAnyException();
    }

    @DisplayName("로또 매칭 식별자 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases2")
    public void generateLottoMatchCountTest2(int matchCount, boolean matchBonusNumber, LottoResultMatchId lottoResultMatchId) {
        assertThat(LottoResultMatchId.newInstance(matchCount, matchBonusNumber)).isEqualTo(lottoResultMatchId);
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
                Arguments.of(2, true, LottoResultMatchId.newInstance(2, ANYWAY)),
                Arguments.of(5, true, LottoResultMatchId.newInstance(5, MATCH)),
                Arguments.of(5, false, LottoResultMatchId.newInstance(5, UN_MATCH)),
                Arguments.of(6, false, LottoResultMatchId.newInstance(6, ANYWAY)));
    }
}
