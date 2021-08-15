package edu.nextstep.lottoauto.ticket;

import edu.nextstep.lottoauto.ticketManager.WinningNumbers;
import edu.nextstep.lottoauto.strategy.NumberMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketTest {

    @Test
    void create() {
        // given
        NumberMaker numberMaker = getCustomTicketMaker("1, 2, 3, 4, 5, 6");

        // when
        Ticket ticket = Ticket.create(numberMaker);

        // then
        Assertions.assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest(name = "create_숫자_6개_실패. 입력값 :  {0}")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"}) // given
    void create_숫자_6개_실패(String numbersOfString) {
        // when, then
        assertThatThrownBy(() -> Ticket.create(getCustomTicketMaker(numbersOfString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("복권 번호는 6개가 필요 합니다.");
    }

    @ParameterizedTest(name = "create_범위_밖_숫자_실패. 입력값 :  {0}")
    @ValueSource(strings = {"-1, 1, 3, 4, 5, 45", "0, 1, 3, 4, 5, 45", "1, 3, 4, 5, 45, 46"}) // given
    void create_범위_밖_숫자_실패(String numbersOfString) {
        // when, then
        assertThatThrownBy(() -> Ticket.create(getCustomTicketMaker(numbersOfString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("복권 번호는 1~45 의 범위 안에 있어야 합니다.");
    }

    @Test
    void create_중복_실패() {
        // given
        String numbersOfString = "1, 1, 3, 4, 5, 6";
        // when, then
        assertThatThrownBy(() -> Ticket.create(getCustomTicketMaker(numbersOfString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("복권 번호는 중복되지 않아야 합니다.");
    }


    @Test
    void checkAndUpdateWinningPrize() {
        // given
        NumberMaker numberMaker = getCustomTicketMaker("1, 2, 3, 4, 5, 6");
        Ticket ticket = Ticket.create(numberMaker);
        WinningNumbers winningNumbers = WinningNumbers.from("1, 2, 3, 4, 5, 6");

        // when
        ticket.checkAndUpdateWinningPrize(winningNumbers);

        // then
        Assertions.assertThat(ticket.getPrize()).isEqualTo(Prize.SIX);

    }

    private NumberMaker getCustomTicketMaker(String numbersOfString) {
        return () -> {
            String[] numbersStringArr = numbersOfString.split(",");

            List<Integer> numbers = new ArrayList<>();

            for (String numberString : numbersStringArr) {
                numbers.add(Integer.parseInt(numberString.trim()));
            }

            return numbers;
        };
    }
}