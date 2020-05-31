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

    public static PurchasePrice getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        return PurchasePrice.newInstance(StringUtils.toInt(inputValue));
    }

    private static void validateBlank(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InputValueException("데이터를 입력하세요.");
        }
    }

    public static int getManualLottoCount() {
        System.out.println(NEW_LINE + "수동으로 구매할 로또 수를 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        return StringUtils.toInt(inputValue);
    }

    public static List<LottoTicket> getManualTickets(int manualLottoCount) {
        System.out.println(NEW_LINE + "수동으로 구매할 번호를 입력해 주세요.");

        List<String> manualNumbers = inputManualNumbers(manualLottoCount);
        return manualNumbers.stream()
                .map(LottoTicketFactory::createManualLottoTicket)
                .collect(Collectors.toList());
    }

    private static List<String> inputManualNumbers(int manualLottoCount) {
        return Stream.generate(() -> {
                    String inputValue = SCANNER.nextLine();
                    validateBlank(inputValue);
                    return inputValue;
                })
                .limit(manualLottoCount)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> getLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        return LottoTicket.createNonDuplicateNumbers(inputValue);
    }

    public static LottoNumber getBonusNumber(LottoTicket lastWinLottoTicket) {
        System.out.println(NEW_LINE + "보너스 볼을 입력해 주세요.");
        String inputValue = SCANNER.nextLine();

        validateBlank(inputValue);

        int bonusNumber = StringUtils.toInt(inputValue);
        return LottoNumber.newBonusNumber(bonusNumber, lastWinLottoTicket);
    }
}
