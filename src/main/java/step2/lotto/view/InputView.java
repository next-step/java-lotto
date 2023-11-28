package step2.lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_COUNT_OF_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 번호를 입력해 주세요.";


    public int inputMoney() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public int inputCountOfManualLotto() {
        System.out.println(INPUT_COUNT_OF_MANUAL_LOTTO_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> inputManualLottoNumbers(final int manualLottoTicketCount) {
        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
        return Stream.generate(scanner::nextLine)
            .limit(manualLottoTicketCount)
            .collect(Collectors.toList());
    }

}
