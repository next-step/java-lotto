package lotto.view;

import lotto.service.LottoBuyer;
import lotto.utility.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        int buyAmount = 0;

        try {
            buyAmount = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            System.exit(1);
        }

        return buyAmount;
    }

    public static int inputManualLottoCount(int buyAmount) {
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");

        int manualLottoCount = 0;

        try {
            manualLottoCount = Integer.parseInt(SCANNER.nextLine());

            LottoBuyer.checkCanBuyLotto(buyAmount, manualLottoCount);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
            System.exit(1);
        }

        return manualLottoCount;
    }

    public static void printPromptForManualLottoNumbers() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Integer> inputManualLottoNumbers() {
        String lottoNumbers = SCANNER.nextLine();

        isValidInput(lottoNumbers);

        return Arrays.stream(lottoNumbers.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static String inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

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
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonusNumber = 0;

        try {
            bonusNumber = Integer.parseInt(SCANNER.nextLine());

            Validator.isValidBonusNumber(lastWeekWinningNumbers, bonusNumber);

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        return bonusNumber;
    }

}