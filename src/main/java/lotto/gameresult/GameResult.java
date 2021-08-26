package lotto.gameresult;

import lotto.game.LottoGame;
import lotto.game.Payments;
import lotto.number.WinningNumbers;
import lotto.ticket.Prize;

import java.util.Arrays;

public class GameResult {
    public static final int DECIMAL_POINTS_MAKER = 100;

    private final LottoGame lottoGame;
    private final WinningNumbers winningNumbers;

    public GameResult(LottoGame lottoGame, WinningNumbers winningNumbers) {
        this.lottoGame = lottoGame;
        this.winningNumbers = new WinningNumbers(winningNumbers.getValue());

    }

    public int countTicketsWinning(Prize prize) {
        return (int) lottoGame.getLottoTickets().stream()
                .filter(ticket -> ticket.getPrize(winningNumbers).equals(prize))
                .count();
    }

    public int getTotalPrizeMoney() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> prize.getPrizeMoney() * countTicketsWinning(prize))
                .sum();
    }

    public double getProfitRate() {
        return getProfitRateWithDecimalPoints(lottoGame.getPayment());
    }

    private double getProfitRateWithDecimalPoints(Payments payments) {
        return Math.round(dividePrizeMoneyByPayments(payments) * DECIMAL_POINTS_MAKER) / (double) DECIMAL_POINTS_MAKER;
    }

    private double dividePrizeMoneyByPayments(Payments payments) {
        return this.getTotalPrizeMoney() / (double) payments.getValue();
    }
}
