package lotto.view;

import lotto.domain.*;

import java.io.PrintStream;
import java.util.Objects;

public class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다. %n";
    private static final String DEFAULT_MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치 (%s원)- %d개 %n";
    private static final String SECOND_RANK_MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치(%s원)- %d개 %n";
    private static final String MATCHES_RESULT_MASSAGE = "당첨 통계\n------------------";
    private static final String LOTTERY_YIELD_MASSAGE_FORMAT = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 %s임) %n";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final int BREAK_EVEN_POINT = 1;
    private static final String LOSS_MESSAGE = "손해라는 의미";
    private static final String PROFIT_MESSAGE = "이득이라는 의미";
    private static final String INPUT_MANUAL_PURCHASE_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_FORMAT = "%n[Error: %s]%n%n";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = Objects.requireNonNull(printStream);
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printPurchaseAmountInputMessage() {
        printStream.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseQuantity(PurchaseQuantity manualPurchaseQuantity, PurchaseQuantity automaticPurchaseQuantity) {
        printStream.println();
        printStream.printf(PURCHASE_QUANTITY_MESSAGE_FORMAT, manualPurchaseQuantity.getQuantity(), automaticPurchaseQuantity.getQuantity());
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        printStream.println(lottoTicket);
    }

    public void printWinningLottoNumbersInputMessage() {
        printStream.println();
        printStream.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
    }

    public void printMatchResult(MatchResult matchResult) {
        printStream.println();
        printStream.println(MATCHES_RESULT_MASSAGE);
        for (Rank rank : Rank.winningValues()) {
            printMatchCount(rank, matchResult.countWinningLotteries(rank));
        }
    }

    public void printMatchCount(Rank rank, int count) {
        if (rank.isSecond()) {
            printStream.printf(SECOND_RANK_MATCH_RESULT_MESSAGE_FORMAT, rank.getCountOfMatchForWinning(), rank.getWinningMoney(), count);
            return;
        }
        printStream.printf(DEFAULT_MATCH_RESULT_MESSAGE_FORMAT, rank.getCountOfMatchForWinning(), rank.getWinningMoney(), count);
    }

    public void printLotteryYield(Money purchaseAmount, Money winningAmount) {
        double lotteryYield = winningAmount.divide(purchaseAmount);
        printStream.printf(LOTTERY_YIELD_MASSAGE_FORMAT, lotteryYield, getResultOfProfitOrLoss(lotteryYield));
    }
    
    private String getResultOfProfitOrLoss(double lotteryYield) {
        if (lotteryYield < BREAK_EVEN_POINT) {
            return LOSS_MESSAGE;
        }
        return PROFIT_MESSAGE;
    }

    public void printBonusBallInputMessage() {
        printStream.println(INPUT_BONUS_BALL_MESSAGE);
    }

    public void printManualPurchaseQuantityInputMessage() {
        printStream.println(INPUT_MANUAL_PURCHASE_QUANTITY_MESSAGE);
    }

    public void printManualLottoNumbersInputMessage() {
        printStream.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
    }

    public void printErrorMessage(String message) {
        printStream.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
