package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatusTest {

    @DisplayName("로또 맞춘 개수와 보너스번호에 따라 LottoStatus 값 리턴")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void find_ReturnLottoStatus_AccordingToHitCountAndBonusNumberStatus(int hitCount, BonusNumberStatus bonusNumberStatus, LottoStatus expected) {
        LottoStatus lottoStatus = LottoStatus.find(hitCount, bonusNumberStatus);
        assertThat(lottoStatus).isEqualTo(expected);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(6, BonusNumberStatus.NOT_APPLY, LottoStatus.FIRST),
                Arguments.of(6, BonusNumberStatus.MATCH, LottoStatus.FIRST),
                Arguments.of(6, BonusNumberStatus.MISS, LottoStatus.FIRST),
                Arguments.of(5, BonusNumberStatus.MATCH, LottoStatus.SECOND),
                Arguments.of(5, BonusNumberStatus.MISS, LottoStatus.THIRD),
                Arguments.of(4, BonusNumberStatus.NOT_APPLY, LottoStatus.FOURTH),
                Arguments.of(3, BonusNumberStatus.NOT_APPLY, LottoStatus.FIFTH),
                Arguments.of(3, BonusNumberStatus.MATCH, LottoStatus.FIFTH),
                Arguments.of(2, BonusNumberStatus.NOT_APPLY, LottoStatus.NOTHING),
                Arguments.of(1, BonusNumberStatus.NOT_APPLY, LottoStatus.NOTHING)
        );
    }
}
