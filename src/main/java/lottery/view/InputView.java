package lottery.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottery.domain.LottoNumber;
import lottery.domain.LottoTicket;

public class InputView {

    private static final String INPUT_DELIMITER = ", ";
    private static Scanner scanner = new Scanner(System.in);

    public static int payAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        return purchaseAmount;
    }

    public static LottoTicket getWinLottoTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return LottoTicket.ofIntegerList(convertInputToIntegerList(input));
    }

    private static List<Integer> convertInputToIntegerList(String input) {
        return Arrays.stream(input.split(INPUT_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static LottoNumber getBonusNumber(LottoTicket winLottoTicket) {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return checkBonusNumberInput(bonusNumber, winLottoTicket);
    }

    private static LottoNumber checkBonusNumberInput(int bonusNumber, LottoTicket winLottoTicket) {
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);

        if (isAlreadyPicked(bonusLottoNumber, winLottoTicket)) {
            throw new IllegalArgumentException("이미 뽑힌 당첨 번호는 보너스 번호로 입력할 수 없습니다.");
        }

        return bonusLottoNumber;
    }

    private static boolean isAlreadyPicked(LottoNumber bonusLottoNumber, LottoTicket winLottoTicket) {
        return winLottoTicket.isBonusMatched(bonusLottoNumber);
    }
}
