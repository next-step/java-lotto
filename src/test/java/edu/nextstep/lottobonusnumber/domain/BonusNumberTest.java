package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.CustomException;
import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest(name = "보너스 볼 생성 실패 : 허용 범위 초과 {0}")
    @ValueSource(ints = {0, 46}) // given
    void create_fail_out_of_range(int number) {
        // when, then
        assertThatThrownBy(() -> BonusNumber.of(number, Ticket.madeBy(() -> Arrays.asList(1,2,3,4,5,6))))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("허용 범위 초과");
    }

    @Test
    @DisplayName("보너스 볼 생성 실패 : winningTicket 포함") // given
    void create_fail_already_in_winning_Numbers() {
        // given
        Ticket winningTicket = Ticket.madeBy(() -> Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 7;

        // when, then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, winningTicket))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("당첨 번호에 이미 포함되어 있습니다.");
    }

}
