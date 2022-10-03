package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int askPurchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        int purchaseAmount = SCANNER.nextInt();
        validateGreaterThanZero(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateGreaterThanZero(int inputNumber) {
        if (inputNumber <= 0) {
            throw new IllegalArgumentException("0보다 큰 수만 입력할 수 있습니다.");
        }
    }

    public static int askManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = SCANNER.nextInt();
        validateGreaterThanZero(manualCount);
        return manualCount;
    }

    public static List<String[]> askManualNumbers(int count) {
        ArrayList<String[]> result = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        SCANNER.nextLine();

        for (int i = 0; i < count; i++) {
            result.add(readLottoNumbers());
        }

        return result;
    }

    private static String[] readLottoNumbers() {
        String nextLine = SCANNER.nextLine();
        return nextLine.split(",");
    }

    public static String[] askWinnerNumbers() {

        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return readLottoNumbers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            askWinnerNumbers();
        }
        return new String[]{};
    }

    public static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
