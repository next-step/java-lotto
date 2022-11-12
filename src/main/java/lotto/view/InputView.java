package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningNumbers;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTONUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNINGNUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUBMER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String WINNINGNUMBER_DELIMITER = ", ";

    public PurchaseMoney inputPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int purchaseMoney = toInt(SCANNER.nextLine());

        return new PurchaseMoney(purchaseMoney);
    }

    public int inputManualLottoCount() {
        System.out.println(System.lineSeparator() + INPUT_MANUAL_PURCHASE_COUNT_MESSAGE);
        return toInt(SCANNER.nextLine());
    }

    public List<LottoNumbers> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println(System.lineSeparator() + INPUT_MANUAL_LOTTONUMBER_MESSAGE);

        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottoNumbers.add(LottoNumbers.of(split(SCANNER.nextLine())));
        }

        return manualLottoNumbers;
    }

    public WinningNumbers inputLastWeekWinningNumbers() {
        System.out.println(System.lineSeparator() + INPUT_WINNINGNUMBERS_MESSAGE);
        List<Integer> lastWeekWinningNumbers = split(SCANNER.nextLine());

        return new WinningNumbers(lastWeekWinningNumbers);
    }

    public LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUSNUBMER_MESSAGE);
        int bonusNumber = toInt(SCANNER.nextLine());

        return new LottoNumber(bonusNumber);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private List<Integer> split(String input) {
        return Arrays.stream(input.split(WINNINGNUMBER_DELIMITER))
            .map(this::toInt)
            .collect(toList());
    }
}
