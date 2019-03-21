package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final int MAX_LOTTO_NUMBER_COUNT = 6;

    public static int inputMoney() {
        System.out.println("구입금액을 입력하세요.");
        try {
            int money = new Scanner(System.in).nextInt();
            if (money < 1000) {
                System.out.println("1000원 이상 입력하세요.");
                return 0;
            }
            return money;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            for (String number : new Scanner(System.in).nextLine().split(SEPARATOR)) {
                winningNumbers.add(Integer.parseInt(number.trim()));
            }
            if (winningNumbers.size() < MAX_LOTTO_NUMBER_COUNT) {
                System.out.println("당첨 번호는 6개 입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
        }
        return winningNumbers;
    }

}
