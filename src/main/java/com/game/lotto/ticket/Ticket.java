package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;

import java.util.List;

public class Ticket {
    public static final int PRICE_OF_TICKET_UNIT = 1_000;
    protected List<Integer> numbers;

    public Ticket(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generateNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareWinnerNumbersAndGetStrikes(Ticket winnerTicket) {
        int strikes = 0;
        for (Integer number : this.numbers) {
            strikes = addStrikeIfNumberExists(winnerTicket, strikes, number);
        }
        return strikes;
    }

    private int addStrikeIfNumberExists(Ticket winnerTicket, int strikes, Integer number) {
        if (winnerTicket.getNumbers().contains(number)) {
            return strikes + 1;
        }
        return strikes;
    }
}
