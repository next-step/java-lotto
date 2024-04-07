package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println("구매 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputPassiveLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputPassiveLottoNumbers(int passiveLottoCount) {
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<String> textLottoNumbers = new ArrayList<>();
        String input;

        scanner.nextLine();

        while (scanner.hasNextLine() && passiveLottoCount > 0) {
            input = scanner.nextLine();
            textLottoNumbers.add(input);
            passiveLottoCount--;
        }
        return textLottoNumbers;
    }

    public static String inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
