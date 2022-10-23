package lotto.core;

import java.util.List;

import static lotto.core.TicketPriceInput.DEFAULT_TICKET_PRICE;

public class LottoJudge {

    private static final int MIN_CORRECT_COUNT = 3;

    public WinnerCount judge(Lottos lottos, Lotto winningLottoNumbers) {
        WinnerCount winnerCount = new WinnerCount();
        List<Lotto> lottosToJudge = lottos.getLottos();
        lottosToJudge.stream()
                .mapToInt(lotto -> lotto.getCorrectCount(winningLottoNumbers))
                .filter(this::isValidCount)
                .forEach(correctCount -> winnerCount.plusCount(WinnerRank.fromCount(correctCount)));
        return winnerCount;
    }

    private boolean isValidCount(int correctCount) {
        return correctCount >= MIN_CORRECT_COUNT;
    }
}
