package step2.view;

import step2.model.LottoNumber;
import step2.model.Money;
import step2.model.MoneyAmount;
import step2.util.LottoNumberSplitter;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static MoneyAmount getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int useAmount = Integer.parseInt(scanner.nextLine());

        return MoneyAmount.create(Money.valueOf(useAmount));
    }

    public static int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();

        return manualCount;
    }

    public static List<LottoNumber> getManualLottoNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String manualLottoNumbers = scanner.nextLine();

        return LottoNumberSplitter.split(manualLottoNumbers).stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();

        return LottoNumberSplitter.split(winningNumber).stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    public static LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return LottoNumber.valueOf(bonusNumber);
    }
}
