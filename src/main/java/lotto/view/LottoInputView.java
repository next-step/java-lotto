package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.PurchasePrice;
import lotto.domain.exception.IntegerMismatchException;
import lotto.domain.lottomachine.LottoMachine;
import lotto.domain.lottomachine.ManualLottoMachine;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.MarkingPaper;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningTicket;

public class LottoInputView {

    private LottoInputView() {

    }

    private static final String DELIMITER = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public static int insertPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntData(insertData());
    }

    public static WinningTicket insertWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LottoBalls lottoBalls = insertLottoBalls();

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoBall bonusBall = LottoBall.of(getIntData(insertData()));

        return new WinningTicket(lottoBalls, bonusBall);
    }

    public static int insertManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return getIntData(insertData());
    }

    public static LottoMachine insertManualLottoNumbers(PurchasePrice purchasePrice) {
        MarkingPaper markingPaper = new MarkingPaper();
        ManualLottoMachine lottoMachine = new ManualLottoMachine(markingPaper);

        if (purchasePrice.getPrice() == 0) {
            return lottoMachine;
        }

        markPaper(markingPaper, lottoMachine.getTicketCount(purchasePrice, Ticket.getPrice()));

        return lottoMachine;
    }

    private static void markPaper(MarkingPaper markingPaper, int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            markingPaper.markLottoBalls(insertLottoBalls());
        }
    }

    private static LottoBalls insertLottoBalls() {
        return new LottoBalls(
                Arrays.stream(insertData().split(DELIMITER))
                        .map(LottoInputView::getIntData)
                        .map(LottoBall::of)
                        .collect(Collectors.toUnmodifiableList()));
    }

    private static int getIntData(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IntegerMismatchException();
        }
    }

    private static String insertData() {
        return scanner.nextLine();
    }
}
