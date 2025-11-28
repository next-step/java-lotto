package lotto.view;

import lotto.model.*;

import java.util.*;

public class InputView {
    public static Money readPurchaseAmountInput() {
        Scanner scanner = new Scanner(System.in);
        print("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static WinningLotto readWinningLottoInput() {
        Lotto lotto = readLottoInput();
        LottoNumber lottoNumber = readBonusNumberInput();
        return new WinningLotto(lotto, lottoNumber);
    }

    private static Lotto readLottoInput() {
        Scanner scanner = new Scanner(System.in);
        print("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = scanner.nextLine().split(",");
        Set<LottoNumber> numbers = new HashSet<>();
        for (String input : inputs) {
            numbers.add(LottoNumber.of(input.trim()));
        }
        return new Lotto(numbers);
    }

    private static LottoNumber readBonusNumberInput() {
        Scanner scanner = new Scanner(System.in);
        print("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return LottoNumber.of(bonusNumber);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
