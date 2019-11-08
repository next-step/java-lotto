package lottery.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lottery.domain.LottoMoney;
import lottery.domain.LottoNumber;
import lottery.domain.LottoTicket;
import lottery.domain.LottoTickets;
import lottery.dto.LottoTries;

public class InputView {

    private static final String ILLEGAL_BONUS_NUMBER = "이미 뽑힌 당첨 번호는 보너스 번호로 입력할 수 없습니다.";
    private static final String INPUT_DELIMITER = ", ";
    private static Scanner scanner = new Scanner(System.in);

    public static LottoMoney payAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        return new LottoMoney(purchaseAmount);
    }

    public static LottoTicket getWinLottoTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return convertInputToLottoTicket(input);
    }

    private static LottoTicket convertInputToLottoTicket(String input) {
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
            throw new IllegalArgumentException(ILLEGAL_BONUS_NUMBER);
        }

        return bonusLottoNumber;
    }

    private static boolean isAlreadyPicked(LottoNumber bonusLottoNumber, LottoTicket winLottoTicket) {
        return winLottoTicket.isBonusMatched(bonusLottoNumber);
    }

    public static LottoTries getManualLottoTry(LottoMoney purchaseAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoTriesInput = scanner.nextInt();
        scanner.nextLine();

        return purchaseAmount.getLottoTries(manualLottoTriesInput);
    }

    public static LottoTickets getManualLottoTickets(int manualTries) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < manualTries; i++) {
            manualLottoTickets.add(convertInputToLottoTicket(scanner.nextLine()));
        }
        return new LottoTickets(manualLottoTickets);
    }
}
