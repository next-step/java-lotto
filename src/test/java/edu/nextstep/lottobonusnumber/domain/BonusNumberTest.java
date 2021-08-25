package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 볼 생성 실패 : winningTicket 포함") // given
    void create_fail_already_in_winning_Numbers() {
        // given
        Ticket winningTicket = Ticket.madeBy(new CustomNumbersMaker("1, 2, 3, 4, 5, 6"));
        int bonusNumber = 6;

        // when, then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, winningTicket))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("당첨 번호에 이미 포함되어 있습니다.");
    }

}
