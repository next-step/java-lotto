package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<LottoTicket> getManualLottoTickets() {
        int manualCount = getManualLottoCount();
        return getManualLottoTickets(manualCount);
    }

    private static int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static List<LottoTicket> getManualLottoTickets(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(() -> LottoTicket.createByString(SCANNER.nextLine()))
                     .limit(count)
                     .collect(Collectors.toList());
    }

    public static LottoWinningNumbers getLottoWinningNumbers() {
        LottoTicket winningNumbers = getWinningNumbers();
        LottoNumber bonusNumber = getBonusNumber();
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    private static LottoTicket getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return LottoTicket.createByString(SCANNER.nextLine());
    }

    private static LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(SCANNER.nextInt());
    }
}
