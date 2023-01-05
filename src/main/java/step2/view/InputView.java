package step2.view;

import java.util.*;
import java.util.stream.Collectors;


public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = scanner.nextLine();
        if (!InputException.isInputMoneyPossible(inputMoney)) {
            scanner = new Scanner(System.in);
            return inputMoney();
        }
        int money = Integer.parseInt(inputMoney);
        return money;
    }

    public static int inputManualBuyCount(int money) {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String inputCount = scanner.nextLine();
        if (!InputException.isInputCountPossible(inputCount, money)) {
            scanner = new Scanner(System.in);
            return inputManualBuyCount(money);
        }
        int count = Integer.parseInt(inputCount);
        return count;
    }

    public static List<List<Integer>> inputManualLotto(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottos.add(getLotto());
        }
        return manualLottos;
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLotto();
    }

    private static List<Integer> getLotto() {
        String input = scanner.nextLine();
        String[] lotto = input.split(", ");
        if (!InputException.isInputLottoPossible(lotto) || !InputException.isInputLottoRangePossible(lotto)) {
            scanner = new Scanner(System.in);
            System.out.println("번호를 다시 입력해 주세요.");
            return getLotto();
        }
        return Arrays.stream(lotto).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumber(List<Integer> winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        if (!InputException.isInputBonusPossible(winningLotto, bonusNumber)) {
            scanner = new Scanner(System.in);
            return inputBonusNumber(winningLotto);
        }
        return Integer.parseInt(bonusNumber);
    }
}
