package lotto.domain;

import static lotto.domain.LottoResult.MATCH3;
import static lotto.domain.LottoResult.MATCH4;
import static lotto.domain.LottoResult.MATCH5;
import static lotto.domain.LottoResult.MATCH6;
import static lotto.domain.LottoResult.MATCH_BONUS;
import static lotto.domain.LottoResult.NO_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource
    void enum_정확하게_찾은_경우(LottoResult lottoResult, int matchCount, boolean isBonusNumber) {
        assertThat(lottoResult).isEqualTo(LottoResult.findLottoResult(matchCount, isBonusNumber));
    }

    private static Stream<Arguments> enum_정확하게_찾은_경우() {
        return Stream.of(
            Arguments.of(MATCH3, 3, false),
            Arguments.of(MATCH4, 4, false),
            Arguments.of(MATCH5, 5, false),
            Arguments.of(MATCH_BONUS, 5, true),
            Arguments.of(MATCH6, 6, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void enum_찾을_수_없는_경우(int matchCount, boolean isBonusNumber) {
        assertThat(NO_MATCH).isEqualTo(LottoResult.findLottoResult(matchCount, isBonusNumber));
    }

    private static Stream<Arguments> enum_찾을_수_없는_경우() {
        return Stream.of(
            Arguments.of(2, false),
            Arguments.of(1, false),
            Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,6})
    void 보너스_볼과_관련_없는_당첨(int count) {
        assertThat(LottoResult.findLottoResult(count, true)).isEqualTo(LottoResult.findLottoResult(count, false));
    }
}