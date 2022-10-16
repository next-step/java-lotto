package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.prize.Rank;
import com.game.lotto.count.Strike;

public class MyTicket {
    public static final int PRICE_OF_TICKET_UNIT = 1_000;

    private final SelectedLottoNumbers numbers;

    public MyTicket(LottoNumberGenerator lottoNumberGenerator) {
        numbers = lottoNumberGenerator.generateNumbers();
    }

    public Rank compareWinnerNumbersAndGetStrikes(WinnerTicket winnerTicket) {
        Strike strikes = new Strike();
        for (LottoNumber number : this.numbers.getSelectedNumbers()) {
            addStrikeIfNumberExists(winnerTicket, strikes, number);
        }
        boolean isMyNumberContainsBonusBall = numbers.getSelectedNumbers().contains(winnerTicket.getBonusNumber());
        return Rank.valueOf(strikes, isMyNumberContainsBonusBall);
    }

    private void addStrikeIfNumberExists(WinnerTicket winnerTicket, Strike strikes, LottoNumber number) {
        if (winnerTicket.getNumbers().getSelectedNumbers().contains(number)) {
            strikes.addCount(1);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
