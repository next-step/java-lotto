package lotto.view;

import lotto.domain.number.LottoWinningNumber;
import lotto.domain.vo.LottoMoney;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static LottoMoney inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            int purchaseAmount = Integer.parseInt(SCANNER.nextLine());
            return new LottoMoney(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static LottoWinningNumber inputWinngInfo() {
        List<Integer> winningNumbers = inputLastWinningNumbers();
        int bonusNumber = inputBonusNumber();

        return new LottoWinningNumber(winningNumbers, bonusNumber);
    }

    public static List<Integer> inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String stringWinningNumbers = SCANNER.nextLine();
        return Arrays.stream(stringWinningNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");

        String stringBonusNumber = SCANNER.nextLine();

        return Integer.parseInt(stringBonusNumber);
    }
}
