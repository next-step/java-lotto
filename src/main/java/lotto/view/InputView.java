package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_QUESTIONS = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_PASSIVITY_QUESTION = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INPUT_PASSIVITY_NUMBER = "수동으로 구매할 번호를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int questionPassivityInput() {
        System.out.println();
        System.out.println(INPUT_PASSIVITY_QUESTION);
        int passivity = SCANNER.nextInt();
        SCANNER.nextLine();
        return passivity;
    }

    public static int questionInputMoney() {
        System.out.println(INPUT_MONEY_QUESTION);
        int money = SCANNER.nextInt();
        SCANNER.nextLine();
        return money;
    }

    public static String questionWinnerNumber() {
        System.out.println();
        System.out.println(WINNER_NUMBER_QUESTION);
        return SCANNER.nextLine();
    }

    public static String questionBonusLottoNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_QUESTIONS);
        return SCANNER.nextLine();
    }

    public static List<String> questionInputPassivityLotto(int passivityCount) {
        System.out.println();
        System.out.println(INPUT_PASSIVITY_NUMBER);
        List<String> passivityLottoList = new ArrayList<>();
        for (int i = 0; i < passivityCount; i++) {
            passivityLottoList.add(SCANNER.nextLine());
        }
        return passivityLottoList;
    }
}
