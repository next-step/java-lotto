package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.ManualLottoCount;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ", ";

    public static Amount askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return new Amount(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPurchaseAmount();
        }
    }

    public static ManualLottoCount askManualLottoCount(Amount amount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return new ManualLottoCount(scanner.nextLine(), amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askManualLottoCount(amount);
        }
    }

    public static List<LottoTicket> askManualLottoNumbers(ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(InputView::asklottoTicket)
                .limit(manualLottoCount.value())
                .collect(Collectors.toList());
    }

    public static LottoTicket askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return asklottoTicket();
    }

    private static LottoTicket asklottoTicket() {
        try {
            return new LottoTicket(scanner.nextLine().split(SPLIT_DELIMITER));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("다시 입력해주세요.");
            return asklottoTicket();
        }
    }

    public static LottoNumber askBonusBall(LottoTicket winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            LottoNumber bonusBall = LottoNumber.of(scanner.nextLine());
            checkDuplicationWithWinningNumbers(winningNumbers, bonusBall);
            return bonusBall;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusBall(winningNumbers);
        }
    }

    private static void checkDuplicationWithWinningNumbers(LottoTicket winningNumbers, LottoNumber bonusBall) {
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨숫자를 제외한 숫자여야 합니다.");
        }
    }
}
