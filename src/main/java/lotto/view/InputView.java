package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.PurchaseAmount;
import lotto.model.Lotto;

import java.util.*;

public class InputView {
    public static PurchaseAmount readBudgetInput() {
        Scanner scanner = new Scanner(System.in);
        print("구입금액을 입력해 주세요.");
        return new PurchaseAmount(scanner.nextInt());
    }

    public static Lotto readWinningLottoInput() {
        Scanner scanner = new Scanner(System.in);
        print("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scanner.nextLine().split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String input : inputs) {
            int number = Integer.parseInt(input.trim());
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    public static LottoNumber readBonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        print("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return new LottoNumber(bonusNumber);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
