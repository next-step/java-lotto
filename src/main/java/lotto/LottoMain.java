package lotto;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.domain.Lotto.*;
import static lotto.domain.LottoPrize.calculatePrizeCounts;
import static lotto.domain.LottoPrize.calculateReturnRate;
import static lotto.view.InputView.readInput;
import static lotto.view.ResultView.*;

public class LottoMain {
    public static void main(String[] args) {
        // 사용자로부터 구매 금액 입력받기
        String purchaseAmount = readInput("구입금액을 입력해 주세요.");
        int purchaseCount = calculateTicketCount(purchaseAmount);

        // 구매 티켓 수 출력
        printPurchaseTickets(purchaseCount);

        // 로또 자동 생성 및 출력
        List<List<Integer>> tickets = generateTickets(purchaseCount);
        printGenerateTickets(tickets);

        // 당첨 번호 입력받기
        List<Integer> winningNumbers = Lotto.parse(readInput("지난 주 당첨 번호를 입력해 주세요."));

        // 상금 통계 및 수익률 출력
        printPrizeStatistics(calculatePrizeCounts(winningNumbers, tickets));
        printReturnRate(calculateReturnRate(winningNumbers, tickets));
    }
}
