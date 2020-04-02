package lotto.model;

import lotto.model.wrapper.LottoResultMatchId;
import lotto.model.wrapper.WinningLottoMatchingCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("로또 결과 테스트")
public class LottoResultTests {

    @DisplayName("로또 결과 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoResultCases")
    public void generateLottoResultTests(final LottoResultMatchId matchCount) {
        assertThatCode(() -> LottoResult.of(matchCount)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 - 비정상 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoAbnormalResultCases")
    public void generateLottoAbnormalResultTests(final LottoResultMatchId matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoResult.of(matchCount))
                .withMessageContaining("일치하는 당첨 케이스가 없습니다.");
    }

    @DisplayName("로또 결과 파라미터 테스트")
    @Test
    public void lottoResultTests() {
        assertThat(LottoResult.FOUR.getPrice()).isEqualTo(50_000L);
        assertTrue(LottoResult.TWO.isBlank());
        assertFalse(LottoResult.FIVE.isBlank());
        assertThat(LottoResult.FIVE_WITH_BONUS.getMatchCount()).isEqualTo(5);
    }

    private static Stream<Arguments> generateLottoResultCases() {
        return Stream.of(
                Arguments.of(LottoResultMatchId.newInstance(0, false)),
                Arguments.of(LottoResultMatchId.newInstance(1, false)),
                Arguments.of(LottoResultMatchId.newInstance(WinningLottoMatchingCount.of(2), LottoBonusNumberMatch.ANYWAY)),
                Arguments.of(LottoResultMatchId.newInstance(3, false)),
                Arguments.of(LottoResultMatchId.newInstance(WinningLottoMatchingCount.of(4), LottoBonusNumberMatch.ANYWAY)),
                Arguments.of(LottoResultMatchId.newInstance(5, false)),
                Arguments.of(LottoResultMatchId.newInstance(5, true)),
                Arguments.of(LottoResultMatchId.newInstance(WinningLottoMatchingCount.of(6), LottoBonusNumberMatch.ANYWAY)));
    }

    private static Stream<Arguments> generateLottoAbnormalResultCases() {
        return Stream.of(
                Arguments.of(LottoResultMatchId.newInstance(6, LottoBonusNumberMatch.UN_MATCH)),
                Arguments.of(LottoResultMatchId.newInstance(WinningLottoMatchingCount.of(4), LottoBonusNumberMatch.UN_MATCH))
        );
    }

}
