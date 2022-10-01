package com.game.lotto.ticket;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.LottoNumberGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private final String[] lottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
    private final String[] winnerLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
    private Ticket randomTicket;
    private Ticket manualTicket;

    @BeforeEach
    void set_up() {
        randomTicket = new Ticket(new RandomLottoNumberGenerator());
        manualTicket = new Ticket(new ManualLottoNumberGenerator(lottoNumbers));
    }

    @Test
    void get_ticket_of_random_numbers() {
        List<Integer> randomNumbersOfTicket = randomTicket.getNumbers();
        assertEquals(LOTTO_NUMBER_SELECT_COUNT, randomNumbersOfTicket.size());
        for (int number : randomNumbersOfTicket) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }

    @Test
    void get_ticket_of_manual_numbers() {
        List<Integer> manualNumbersOfTicket = manualTicket.getNumbers();
        assertEquals(LOTTO_NUMBER_SELECT_COUNT, manualNumbersOfTicket.size());
        for (int number : manualNumbersOfTicket) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }

    @Test
    void get_ticket_strikes_by_random_numbers() {
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(winnerLottoNumbers));
        int strikes = randomTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(strikes).isGreaterThanOrEqualTo(0);
        assertThat(strikes).isLessThanOrEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }

    @Test
    void get_ticket_strikes_by_manual_numbers() {
        Ticket winnerTicket = new Ticket(new ManualLottoNumberGenerator(winnerLottoNumbers));
        int strikes = manualTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(strikes).isEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }
}