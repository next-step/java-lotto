package lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int NOT_NUMBER = -1;

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount;
        do {
            amount = input();
        } while (amount == NOT_NUMBER);

        return amount;
    }

    public static int inputDirectCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count;
        do {
            count = input();
        } while (count == NOT_NUMBER);

        return count;
    }

    private static int input() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력해 주세요.");
        }

        return NOT_NUMBER;
    }

    public static List<String> inputDirectLottoNumbers(final int directCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        final List<String> directLottoNumbers = new ArrayList<>();

        for (int i = 0; i < directCount; i++) {
            directLottoNumbers.add(new Scanner(System.in).nextLine());
        }

        return directLottoNumbers;
    }

    public static String inputWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
