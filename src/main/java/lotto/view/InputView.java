package lotto.view;

import lotto.domain.LottoNumber;
import lotto.dto.ManualLottoNumberRequestDto;
import lotto.dto.ManualLottoNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Long askTotalMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.valueOf(SCANNER.nextLine());
    }

    public static int askNumberOfManualLottoTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static ManualLottoNumberRequestDto askManualTicketNumbers(int numberOfManualLottoTicket) {
        List<ManualLottoNumbers> manualLottoNumbers = new ArrayList<>();
        if (numberOfManualLottoTicket > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        for (int i = 0; i < numberOfManualLottoTicket; i++) {
            manualLottoNumbers.add(new ManualLottoNumbers(SCANNER.nextLine()));
        }
        return new ManualLottoNumberRequestDto(manualLottoNumbers);
    }

    public static Set<LottoNumber> askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(winningNumber -> Integer.valueOf(winningNumber.trim()))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return Integer.parseInt(SCANNER.nextLine());
    }

}
