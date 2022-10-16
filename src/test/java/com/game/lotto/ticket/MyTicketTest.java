package com.game.lotto.ticket;

import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.prize.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.game.lotto.number.LottoNumberGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyTicketTest {

    private final static int BONUS_NUMBER = 7;

    private final List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> winnerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private MyTicket randomMyTicket;
    private MyTicket manualMyTicket;

    @BeforeEach
    void set_up() {
        randomMyTicket = new MyTicket(new RandomLottoNumberGenerator());
        manualMyTicket = new MyTicket(new ManualLottoNumberGenerator(lottoNumbers));
    }

    @Test
    void get_ticket_of_random_numbers() {
        List<Integer> randomNumbersOfTicket = randomMyTicket.getNumbers();
        assertEquals(LOTTO_NUMBER_SELECT_COUNT, randomNumbersOfTicket.size());
        for (int number : randomNumbersOfTicket) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }

    @Test
    void get_ticket_of_manual_numbers() {
        List<Integer> manualNumbersOfTicket = manualMyTicket.getNumbers();
        assertEquals(LOTTO_NUMBER_SELECT_COUNT, manualNumbersOfTicket.size());
        for (int number : manualNumbersOfTicket) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }

    @Test
    void get_ticket_strikes_by_random_numbers() {
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerLottoNumbers), BONUS_NUMBER);
        Rank rank = randomMyTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(rank.getStrikes()).isGreaterThanOrEqualTo(0);
        assertThat(rank.getStrikes()).isLessThanOrEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }

    @Test
    void get_ticket_strikes_by_manual_numbers() {
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerLottoNumbers), BONUS_NUMBER);
        Rank rank = manualMyTicket.compareWinnerNumbersAndGetStrikes(winnerTicket);
        assertThat(rank.getStrikes()).isEqualTo(LOTTO_NUMBER_SELECT_COUNT);
    }
}