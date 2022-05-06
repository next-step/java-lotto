package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_REGEX = ",";
    private static final Scanner INPUT = new Scanner(System.in);

    public static int inputHowMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return INPUT.nextInt();
    }

    public static String[] inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력 해 주세요.");
        return INPUT.next().split(SPLIT_REGEX);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return INPUT.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return INPUT.nextInt();
    }

    public static List<String[]> inputManualLottoNumbers(int count) {
        List<String[]> result = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        INPUT.nextLine();

        for (int i = 0; i < count; i++) {
            result.add(INPUT.nextLine().split(SPLIT_REGEX));
        }
        return result;
    }

}
