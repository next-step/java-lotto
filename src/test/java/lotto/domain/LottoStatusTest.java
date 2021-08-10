package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatusTest {

    @DisplayName("로또 맞춘 개수에 따라 LottoStatus 값 리턴")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void find_ReturnLottoStatus_AccordingToHitCount(int hitCount, LottoStatus expected) {
        LottoStatus lottoStatus = LottoStatus.find(hitCount);
        assertThat(lottoStatus).isEqualTo(expected);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(6, LottoStatus.FIRST),
                Arguments.of(5, LottoStatus.SECOND),
                Arguments.of(4, LottoStatus.THIRD),
                Arguments.of(3, LottoStatus.FOURTH),
                Arguments.of(2, LottoStatus.NOTHING),
                Arguments.of(1, LottoStatus.NOTHING),
                Arguments.of(0, LottoStatus.NOTHING)
        );
    }
}
