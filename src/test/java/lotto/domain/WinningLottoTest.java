package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WinningLottoTest {

    @Test
    @DisplayName("우승 번호 생성 테스트")
    void create() {
        assertNotNull(WinningLotto.of(45,1, 2, 3, 4, 5, 6));
        assertNotNull(WinningLotto.of(1, 40, 41, 42, 43, 44, 45));
    }

    @Test
    @DisplayName("우승 번호 유효성 검사")
    void create_validate() {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(45, 1, 2, 3, 4, 5)); // 5개
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(45, 0, 1, 2, 3, 4, 5)); // 범위
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(45, 1, 2, -3, 4, 5, 6)); // 범위
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(40, 41, 42, 43, 44, 45, 46)); // 범위
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(1, 1, 2, 3, 4, 5, 6)); // 보너스와 중
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndResult")
    @DisplayName("추첨 결과 확인(보너스 포함된 경우와 포함되지 않은 경우)")
    void matching(LottoNumbers ticket, Prize expected) {
        // given
        WinningLotto winningNumbers = WinningLotto.of(45, 1, 2, 3, 4, 5, 6);

        // when
        Prize actual = winningNumbers.matching(ticket);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersAndResult() {
        return Stream.of(
                Arguments.of(LottoNumbers.of(7, 8, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 8, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 2, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 2, 3, 7, 8, 9), Prize.FIFTH),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 8, 9), Prize.FOURTH),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 5, 9), Prize.THIRD),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 5, 45), Prize.SECOND),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 5, 6), Prize.FIRST)
        );
    }
}
