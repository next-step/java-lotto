package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int LOTTO_UNIT_NUMBER = 6;
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumberString = scanner.nextLine().split(", ");
        Integer[] winningNumber = new Integer[LOTTO_UNIT_NUMBER];

        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            winningNumber[i] = Integer.parseInt(winningNumberString[i]);
        }

        return Arrays.asList(winningNumber);
    }


}
