package lotto.view;

import lotto.domain.*;
import lotto.exception.InputValueException;
import lotto.util.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NEW_LINE = System.lineSeparator();

    private InputView() {
    }

    public static PurchaseAmount getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        return PurchaseAmount.newInstance(StringUtils.toInt(inputValue));
    }

    private static void validateBlank(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InputValueException("데이터를 입력하세요.");
        }
    }

    public static ManualLottoCount getManualLottoCount(PurchaseAmount purchaseAmount) {
        System.out.println(NEW_LINE + "수동으로 구매할 로또 수를 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        int manualLottoCount = StringUtils.toInt(inputValue);
        return ManualLottoCount.newInstance(manualLottoCount, purchaseAmount);
    }

    public static ManualNumbers getManualNumbers(ManualLottoCount manualLottoCount) {
        System.out.println(NEW_LINE + "수동으로 구매할 번호를 입력해 주세요.");

        return ManualNumbers.newInstance(inputManualNumbers(manualLottoCount));
    }

    private static List<String> inputManualNumbers(ManualLottoCount manualLottoCount) {
        return Stream.generate(() -> {
                    String inputValue = SCANNER.nextLine();
                    validateBlank(inputValue);
                    return inputValue;
                })
                .limit(manualLottoCount.getManualLottoCount())
                .collect(Collectors.toList());
    }

    public static List<Integer> getLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        return LottoNumber.createNonDuplicateNumbers(inputValue);
    }

    public static BonusNumber getBonusNumber(LottoNumber lastWinLottoNumber) {
        System.out.println(NEW_LINE + "보너스 볼을 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        int bonusNumber = StringUtils.toInt(inputValue);
        return BonusNumber.newInstance(bonusNumber, lastWinLottoNumber);
    }
}
