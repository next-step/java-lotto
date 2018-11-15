package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoWallet;
import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.utils.LottoCollectionUtils.convert;

public class InputView {

    private InputView() {

    }

    public static LottoWallet inputMoneyAndManualNumbers() {
        int money = inputMoney();
        int manualCount = inputManualCount();
        List<Lotto> manualNumbers = inputManualNumbers(manualCount);

        return LottoWallet.create(money, manualNumbers);
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        LottoValidator.throwExceptionWhenHasNoInt(scanner);
        return scanner.nextInt();
    }

    private static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        LottoValidator.throwExceptionWhenHasNoInt(scanner);
        return scanner.nextInt();
    }

    private static List<Lotto> inputManualNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Lotto> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String[] texts = scanner.nextLine().split(", ");
            LottoValidator.throwExceptionWhenHasNoText(texts);
            manualNumbers.add(Lotto.create(convert(texts), false));
        }
        return manualNumbers;
    }

    public static List<LottoNo> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String[] texts = scanner.nextLine().split(", ");
        LottoValidator.throwExceptionWhenHasNoText(texts);
        return convert(texts);
    }

    public static LottoNo inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        LottoValidator.throwExceptionWhenHasNoInt(scanner);
        return LottoNo.create(scanner.nextInt());
    }
}
