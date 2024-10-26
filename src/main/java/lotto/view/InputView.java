package lotto.view;

import lotto.model.WinningLotto;
import lotto.service.LottoBuyer;
import lotto.utility.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyAmount() {
        int buyAmount = 0;

        try {
            buyAmount = Integer.parseInt(SCANNER.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }

        return buyAmount;
    }

    public static int inputManualLottoCount(int buyAmount) {
        int manualLottoCount = 0;

        try {
            manualLottoCount = Integer.parseInt(SCANNER.nextLine());

            LottoBuyer.checkCanBuyLotto(buyAmount, manualLottoCount);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }

        return manualLottoCount;
    }

    public static List<Integer> inputManualLottoNumbers() {
        String lottoNumbers = SCANNER.nextLine();

        isValidInput(lottoNumbers);

        return Arrays.stream(lottoNumbers.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static String inputWinningNumbers() {
        String winningNumbers = SCANNER.nextLine();
        isValidInput(winningNumbers);

        return winningNumbers;
    }

    private static void isValidInput(String input) {
        Validator.isValidFormat(input);

        List<Integer> numbers = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Validator.isValidNumbers(numbers);
    }

    public static int inputBonusNumber(String lastWeekWinningNumbers) {
        int bonusNumber = SCANNER.nextInt();

        WinningLotto.isValidBonusNumber(lastWeekWinningNumbers, bonusNumber);

        return bonusNumber;
    }

}
