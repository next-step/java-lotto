package dev.dahye.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusBallTest {
    private static LottoTicket winningTicket;

    @BeforeEach
    void setUp() {
        winningTicket = LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "보너스 볼 = {0}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("보너스 볼은 로또 번호의 유효성 검증 로직에 부합하지 않는 경우 IllegalArgumentException throw")
    void validate_bonus_ball(int bonusNumber) {
        assertThrows(IllegalArgumentException.class, () -> BonusBall.createBy(bonusNumber, winningTicket));
    }

    @ParameterizedTest(name = "보너스 볼 = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("보너스 볼은 당첨 번호와 중복될 수 없다.")
    void duplicate_bonus_ball(int bonusNumber) {
        assertThatThrownBy(() -> BonusBall.createBy(bonusNumber, winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }

}