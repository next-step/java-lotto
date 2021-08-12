package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.MatchCount;
import lotto.domain.MatchResult;

import java.io.PrintStream;
import java.util.Objects;

public class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다. %n";
    private static final String MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개 %n";
    private static final String MATCHES_RESULT_MASSAGE = "당첨 통계";

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

    public void printPurchaseCount(long quantity) {
        printStream.printf(PURCHASE_QUANTITY_MESSAGE_FORMAT, quantity);
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.foreach(this::printLottoNumbers);
    }

    private void printLottoNumbers(LottoNumbers lottoNumbers) {
        printStream.println(lottoNumbers.toString());
    }

    public void printWinningLottoNumbersInputMessage() {
        printStream.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
    }

    public void printMatchResult(MatchResult matchResult) {
        printStream.println(MATCHES_RESULT_MASSAGE);
        for (MatchCount matchCount : MatchCount.values()) {
            printMatchCount(matchCount, matchResult.countWinningLotteries(matchCount));
        }
    }

    private void printMatchCount(MatchCount matchCount, int count) {
        printStream.printf(MATCH_RESULT_MESSAGE_FORMAT, matchCount.getCount(), matchCount.getWinningAmount(), count);
    }
}
