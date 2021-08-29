package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }

    public static int inputCountOfCustomLotto(Money money) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int inputCount = Integer.parseInt(scanner.nextLine());
        validCountOfCustomLotto(money, inputCount);
        return inputCount;
    }

    private static void validCountOfCustomLotto(Money money, int inputCount) {
        if(inputCount > money.countOfLottoPurchases()) {
            throw new IllegalArgumentException("수동으로 구매한 로또 수가 전체 구매 로또 수보다 큽니다.");
        }
    }

    public static List<String> inputCustomLotto(int customLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> customLottos = new ArrayList<>();
        for (int i = 0; i < customLottoCount; i++) {
            String lotto = scanner.nextLine();
            customLottos.add(lotto);
        }

        return customLottos;
    }

    public static String inputWinningNumbersLastWeek() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }

}
