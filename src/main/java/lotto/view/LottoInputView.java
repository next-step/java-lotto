package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.exception.IntegerMismatchException;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.WinningTicket;

public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int insertPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntData(insertData());
    }

    public static WinningTicket insertWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        LottoBalls lottoBalls = new LottoBalls(
                Arrays.stream(insertData().split(", "))
                        .map(LottoInputView::getIntData)
                        .map(LottoBall::new)
                        .collect(Collectors.toUnmodifiableList()));

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoBall bonusBall = new LottoBall(getIntData(insertData()));

        return new WinningTicket(lottoBalls, bonusBall);
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
