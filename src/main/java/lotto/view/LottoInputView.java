package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.exception.IntegerMismatchException;
import lotto.domain.number.WinningNumbers;

public class LottoInputView {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int insertPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return getIntData(insertData());
    }

    public static WinningNumbers insertWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningNumbers(
                Arrays.stream(insertData().split(", "))
                        .map(LottoInputView::getIntData)
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
