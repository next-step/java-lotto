package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.prize.Rank;

import java.util.List;

public class MyTicket {
    public static final int PRICE_OF_TICKET_UNIT = 1_000;

    private final List<Integer> numbers;

    public MyTicket(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generateNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank compareWinnerNumbersAndGetStrikes(WinnerTicket winnerTicket) {
        int strikes = 0;
        for (Integer number : this.numbers) {
            strikes = addStrikeIfNumberExists(winnerTicket, strikes, number);
        }
        boolean containsBonusBall = strikes == 5 && numbers.contains(winnerTicket.getBonusNumber());
        return Rank.valueOf(strikes, containsBonusBall);
    }

    private int addStrikeIfNumberExists(WinnerTicket winnerTicket, int strikes, Integer number) {
        if (winnerTicket.getNumbers().contains(number)) {
            return strikes + 1;
        }
        return strikes;
    }
}
