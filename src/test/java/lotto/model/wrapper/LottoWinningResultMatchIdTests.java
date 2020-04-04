package lotto.model.wrapper;

import lotto.model.BonusNumberMatchingStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.model.BonusNumberMatchingStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("로또 매칭 식별자 테스트")
public class LottoWinningResultMatchIdTests {

    @DisplayName("로또 매칭 식별자 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases")
    public void generateLottoMatchCountTest(int matchCount, BonusNumberMatchingStatus bonusNumberMatchingStatus) {
        assertThatCode(() -> LottoWinningResultMatchId.newInstance(matchCount, bonusNumberMatchingStatus)).doesNotThrowAnyException();
    }

    @DisplayName("로또 매칭 식별자 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoMatchCountTestCases2")
    public void generateLottoMatchCountTest2(int matchCount, boolean matchBonusNumber, LottoWinningResultMatchId lottoWinningResultMatchId) {
        assertThat(LottoWinningResultMatchId.newInstance(matchCount, matchBonusNumber)).isEqualTo(lottoWinningResultMatchId);
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
                Arguments.of(2, true, LottoWinningResultMatchId.newInstance(2, ANYWAY)),
                Arguments.of(5, true, LottoWinningResultMatchId.newInstance(5, MATCH)),
                Arguments.of(5, false, LottoWinningResultMatchId.newInstance(5, UN_MATCH)),
                Arguments.of(6, false, LottoWinningResultMatchId.newInstance(6, ANYWAY)));
    }
}
