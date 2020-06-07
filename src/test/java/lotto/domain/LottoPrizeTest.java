package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest
    @MethodSource("provideLottoMatchCount")
    @DisplayName("맞춘 번호 갯수에 대한 정보 잘 가져오는지 체크")
    void getPrize(int count, LottoPrize expected) {
        LottoPrize result = LottoPrize.valueOf(count);
        assertThat(result).isEqualByComparingTo(expected);
    }

    private static Stream<Arguments> provideLottoMatchCount() {
        return Stream.of(
                Arguments.of(3, LottoPrize.MATCH_THIRD),
                Arguments.of(4, LottoPrize.MATCH_FOURTH),
                Arguments.of(2, LottoPrize.MISS),
                Arguments.of(0, LottoPrize.MISS)
        );
    }
}
