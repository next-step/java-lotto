package lotto.view;

import lotto.dto.input.PurchaseDto;
import lotto.dto.input.WinningConditionDto;
import lotto.exception.NanException;
import lotto.view.printable.QuestionPrintable;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void printQuestion(String question) {
        new QuestionPrintable(question).print();
    }

    public static PurchaseDto getPurchaseDto() {
        int purchaseMoney = askPurchaseMoney();
        int numOfManualLottos = askNumOfManualLottos();
        List<String> manualLottos = askManualLotto(numOfManualLottos);
        return new PurchaseDto(purchaseMoney, numOfManualLottos, manualLottos);
    }

    public static WinningConditionDto getWinningConditionDto() {
        String winningLotto = askWinningLotto();
        int bonus = askBonusBall();
        return new WinningConditionDto(winningLotto, bonus);
    }

    private static int askPurchaseMoney() {
        printQuestion("구입금액을 입력해 주세요.");
        return nextInt();
    }

    private static int askNumOfManualLottos() {
        printQuestion("수동으로 구매할 로또 수를 입력해 주세요.");
        return nextInt();
    }

    private static List<String> askManualLotto(int numOfManualLottos) {
        printQuestion("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new LinkedList<>();
        for (int i = 0; i < numOfManualLottos; i++) {
            manualLottos.add(nextLine());
        }
        return manualLottos;
    }

    private static String askWinningLotto() {
        printQuestion("지난 주 당첨 번호를 입력해 주세요.");
        return nextLine();
    }

    private static int askBonusBall() {
        printQuestion("보너스 볼을 입력해 주세요.");
        return nextInt();
    }

    private static String nextLine() {
        return scanner.nextLine();
    }

    private static int nextInt() {
        String numStr = nextLine();
        try {
            return Integer.parseInt(numStr);
        } catch (Exception e) {
            throw NanException.getInstance();
        }
    }
}
