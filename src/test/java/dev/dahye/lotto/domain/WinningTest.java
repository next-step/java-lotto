package dev.dahye.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningTest {
    private static LottoTicket winningTicket;

    @BeforeEach
    void setUp() {
        winningTicket = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "보너스 볼 = {0}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("보너스 볼은 로또 번호의 유효성 검증 로직에 부합하지 않는 경우 IllegalArgumentException throw")
    void validate_bonus_ball(int bonusNumber) {
        assertThrows(IllegalArgumentException.class, () -> Winning.of(winningTicket, LottoNumber.of(bonusNumber)));
    }

    @ParameterizedTest(name = "보너스 볼 = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("보너스 볼은 당첨 번호와 중복될 수 없다.")
    void duplicate_bonus_ball(int bonusNumber) {
        assertThatThrownBy(() -> Winning.of(winningTicket, LottoNumber.of(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("nullCases")
    @DisplayName("로또 티켓이 없는 경우 LottoTickets를 생성할 수 없다.")
    void exception_lottoMoney_is_null(LottoTicket winningTicket, LottoNumber bonusNumber) {
        assertThatThrownBy(() -> Winning.of(winningTicket, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Winning 객체를 생성할 수 없습니다.");
    }

    private static Stream<Arguments> nullCases() {
        return Stream.of(
                arguments(null, LottoNumber.of(1)),
                arguments(LottoTicket.autoIssued(), null),
                arguments(null, null)
        );
    }
}