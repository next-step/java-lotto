package lotto.model;

import lotto.model.wrapper.LottoNumberWinningCount;
import lotto.model.wrapper.LottoWinningResultMatchId;
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
public class LottoWinningResultTests {

    @DisplayName("로또 결과 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoResultCases")
    public void generateLottoResultTests(final LottoWinningResultMatchId matchCount) {
        assertThatCode(() -> LottoWinningResult.of(matchCount)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 - 비정상 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoAbnormalResultCases")
    public void generateLottoAbnormalResultTests(final LottoWinningResultMatchId matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoWinningResult.of(matchCount))
                .withMessageContaining("일치하는 당첨 케이스가 없습니다.");
    }

    @DisplayName("로또 결과 파라미터 테스트")
    @Test
    public void lottoResultTests() {
        assertThat(LottoWinningResult.FOUR.getPrice()).isEqualTo(50_000L);
        assertTrue(LottoWinningResult.TWO.isBlank());
        assertFalse(LottoWinningResult.FIVE.isBlank());
        assertThat(LottoWinningResult.FIVE_WITH_BONUS.getLottoWinningResultMatchId()).isEqualTo(5);
    }

    private static Stream<Arguments> generateLottoResultCases() {
        return Stream.of(
                Arguments.of(LottoWinningResultMatchId.newInstance(0, false)),
                Arguments.of(LottoWinningResultMatchId.newInstance(1, false)),
                Arguments.of(LottoWinningResultMatchId.newInstance(LottoNumberWinningCount.of(2), BonusNumberMatchingStatus.ANYWAY)),
                Arguments.of(LottoWinningResultMatchId.newInstance(3, false)),
                Arguments.of(LottoWinningResultMatchId.newInstance(LottoNumberWinningCount.of(4), BonusNumberMatchingStatus.ANYWAY)),
                Arguments.of(LottoWinningResultMatchId.newInstance(5, false)),
                Arguments.of(LottoWinningResultMatchId.newInstance(5, true)),
                Arguments.of(LottoWinningResultMatchId.newInstance(LottoNumberWinningCount.of(6), BonusNumberMatchingStatus.ANYWAY)));
    }

    private static Stream<Arguments> generateLottoAbnormalResultCases() {
        return Stream.of(
                Arguments.of(LottoWinningResultMatchId.newInstance(6, BonusNumberMatchingStatus.UN_MATCH)),
                Arguments.of(LottoWinningResultMatchId.newInstance(LottoNumberWinningCount.of(4), BonusNumberMatchingStatus.UN_MATCH))
        );
    }

}
