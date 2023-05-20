package lotto.view;

import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String REGEX = ",";

    public static String inputLottoCost() {
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<LottoNumber> inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(REGEX))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(Integer.parseInt(scanner.next()));
    }

    public static int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.next());
    }

    public static List<LottoNumber> inputManualTicketNumbers() {
        scanner.nextLine();
        return Arrays.stream(scanner.nextLine().split(REGEX))
                .map(Integer::parseInt)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static void printManualTicketGuideMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
