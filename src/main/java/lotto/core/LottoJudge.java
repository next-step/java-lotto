package lotto.core;

import java.util.List;

import static lotto.core.TicketPriceInput.DEFAULT_TICKET_PRICE;

public class LottoJudge {

    public static final int MIN_CORRECT_COUNT = 3;
    private WinnerCount winnerCount;
    private Double profitRatio;

    public void judge(Lottos lottos, WinningNumbers winningNumbers) {
        WinnerCount winnerCount = new WinnerCount();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.stream()
                .mapToInt(lotto -> lotto.getCorrectCount(winningNumbers))
                .filter(this::isValidCount)
                .forEach(correctCount -> winnerCount.plusCount(WinnerRank.fromCount(correctCount)));
        this.winnerCount = winnerCount;
        this.profitRatio = winnerCount.getAllProfit() / (double) (lottos.getLottosAmount() * DEFAULT_TICKET_PRICE);
    }

    private boolean isValidCount(int correctCount) {
        return correctCount >= MIN_CORRECT_COUNT;
    }

    public WinnerCount getWinnerCount() {
        return winnerCount;
    }

    public Double getProfitRatio() {
        return profitRatio;
    }
}
