package lotto_tests;

import lotto.model.LottoBonusMatchResult;
import lotto.model.LottoResult;
import lotto.model.wrapper.LottoMatchCount;
import org.junit.jupiter.api.DisplayName;
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
    public void generateLottoResultTests(final LottoMatchCount matchCount) {
        assertThatCode(() -> LottoResult.of(matchCount)).doesNotThrowAnyException();
    }

    @DisplayName("로또 결과 - 비정상 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoAbnormalResultCases")
    public void generateLottoAbnormalResultTests(final LottoMatchCount matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoResult.of(matchCount))
                .withMessageContaining("match count must between 0 and 6.");
    }

    @DisplayName("로또 결과 파라미터 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoAbnormalResultCases")
    public void lottoResultTests() {
        assertThat(LottoResult.FOUR.getPrice()).isEqualTo(50_000L);
        assertTrue(LottoResult.TWO.isBlank());
        assertFalse(LottoResult.FIVE.isBlank());
        assertThat(LottoResult.FIVE_WITH_BONUS.getMatchCount()).isEqualTo(5);
    }

    private static Stream<Arguments> generateLottoResultCases() {
        return Stream.of(
                Arguments.of(LottoMatchCount.create(0, false)),
                Arguments.of(LottoMatchCount.create(1, false)),
                Arguments.of(LottoMatchCount.newInstance(2, LottoBonusMatchResult.ANYWAY)),
                Arguments.of(LottoMatchCount.create(3, false)),
                Arguments.of(LottoMatchCount.newInstance(4, LottoBonusMatchResult.ANYWAY)),
                Arguments.of(LottoMatchCount.create(5, false)),
                Arguments.of(LottoMatchCount.create(5, true)),
                Arguments.of(LottoMatchCount.newInstance(6, LottoBonusMatchResult.ANYWAY)));
    }

    private static Stream<Arguments> generateLottoAbnormalResultCases() {
        return Stream.of(
                Arguments.of(LottoMatchCount.create(7, true)),
                Arguments.of(LottoMatchCount.newInstance(-5, LottoBonusMatchResult.UN_MATCH)),
                Arguments.of(LottoMatchCount.newInstance(5, LottoBonusMatchResult.ANYWAY)));
    }

}
