package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningTicketTest {

    @Test
    @DisplayName("WinningTicket 생성 성공")
    void of_success() {
        // given
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;

        // when
        WinningTicket winningTicket = WinningTicket.of(winningNumbersString, bonusNumber);

        // then
        assertThat(winningTicket.getWinningTicket()).isEqualTo(Ticket.madeBy(() -> createNumbersFromTo(1, 6)));
        assertThat(winningTicket.getBonusNumber()).isEqualTo(bonusNumber);

    }

    @ParameterizedTest(name = "WinningTicket 생성 실패 : 보너스 번호 허용 범위 초과 [{index}] {0}")
    @CsvSource({"0", "46"}) // given
    void of_fail_out_of_ranges(int bonusNumber) {
        // when, then
        assertThatThrownBy(() -> WinningTicket.of("1, 2, 3, 4, 5, 6", bonusNumber))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("지정 가능 숫자 범위 초과.");
    }

    @ParameterizedTest(name = "WinningTicket 생성 실패 : 당첨 번호에 이미 포함 [{index}] {0}")
    @CsvSource({"1", "6"}) // given
    void of_winning_ticket_already_has(int bonusNumber) {
        // when, then
        assertThatThrownBy(() -> WinningTicket.of("1, 2, 3, 4, 5, 6", bonusNumber))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("해당 보너스 볼은 당첨 번호에 이미 포함되어 있습니다.");
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}