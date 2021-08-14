package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import lotto.domain.TicketCount;
import lotto.exception.WrongUserInputException;

public class InputView {

    private static final InputView inputView = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private static final String COMMA_DELIMITER = ",";

    private InputView() {
    }

    public int askMoneyAmount() {
        System.out.println("구입금액을 입력해주세요.");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new WrongUserInputException("잘못된 구입금액이 입력되었습니다.");
        }
    }

    public static InputView getInstance() {
        return inputView;
    }

    public int[] askWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] stringNumberArray = scanner.next().split(COMMA_DELIMITER);

        return convertStringArrayToIntArray(stringNumberArray);
    }

    public int askBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }


    public int askHowManyManualTicketing() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public int[][] askManualTicketNumbers(TicketCount manualTicketCnt) {

        int[][] input = new int[manualTicketCnt.value()][];

        if (input.length == 0) {
            return input;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < input.length; i++) {
            String[] stringNumberArray = scanner.next().split(COMMA_DELIMITER);
            input[i] = convertStringArrayToIntArray(stringNumberArray);
        }

        return input;
    }

    private int[] convertStringArrayToIntArray(String[] stringArray) {

        return Arrays.stream(stringArray)
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .toArray();
    }

}
