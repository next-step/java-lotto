package step3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scan = new Scanner(System.in);

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String cash = scan.nextLine();

        InputValidationCheck.checkEmpty(cash);
        InputValidationCheck.checkCash(cash);

        return Integer.parseInt(cash) / Lotto.LOTTO_PRICE;
    }

    public static ArrayList<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputWinningNumbers = scan.nextLine().split(",");

        InputValidationCheck.checkWinningNumberLength(inputWinningNumbers);
        InputValidationCheck.checkOverlapWinningNumber(inputWinningNumbers);

        String[] trimWinningNumbers = new String[LottoGenerator.WINNING_NUMBERS_LENGTH];
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            trimWinningNumbers[i] = inputWinningNumbers[i].trim();
        }

        int[] winningNumbers = InputValidationCheck.checkWinningNumberRange(trimWinningNumbers);
        Arrays.sort(winningNumbers);

        ArrayList<Integer> inputWinningNumberList = new ArrayList<>();
        for (int i = 0; i < LottoGenerator.WINNING_NUMBERS_LENGTH; i++) {
            inputWinningNumberList.add(winningNumbers[i]);
        }

        return inputWinningNumberList;
    }

    public static void bonusNumberAdd(List<Integer> inputWinningNumberList) {
        System.out.println("보너스 볼을 입력해주세요.");
        Lotto.LOTTO_BONUS_NUMBER = scan.nextInt();

        InputValidationCheck.checkBonusNumber(inputWinningNumberList);
    }
}
