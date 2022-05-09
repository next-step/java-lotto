package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.TicketCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final int START_OF_RANGE = 0;

    private InputView() {
    }

    public static Amount inputPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        return new Amount(SCANNER.nextLine());
    }

    public static TicketCount inputManualTicketsCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new TicketCount(SCANNER.nextLine().trim());
    }

    public static LottoResult inputLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoResult(
                inputLottoNumbers(),
                inputBonusNumber()
        );
    }

    public static List<LottoNumbers> inputLottoNumbers(TicketCount manualTicketsCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(START_OF_RANGE, manualTicketsCount.getTicketCount())
                .mapToObj(index -> inputLottoNumbers())
                .collect(Collectors.toList());
    }


    private static LottoNumbers inputLottoNumbers() {
        return new LottoNumbers(
                split(SCANNER.nextLine(), DELIMITER)
                        .stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    private static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(SCANNER.nextLine().trim());
    }

    private static List<String> split(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
