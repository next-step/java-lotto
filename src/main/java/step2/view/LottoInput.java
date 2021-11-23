package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInput {

    private static final String NUMBER_REGEX = ",";
    private static final int MONEY_MIN = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println("구입 금액을 입력해주세요");
        int money = Integer.parseInt(scanner.nextLine());
        validatePositive(money);
        return money;
    }

    private static void validatePositive(int money) {
        if (money < MONEY_MIN) {
            throw new IllegalArgumentException("돈이 음수일 수 없습니다");
        }
    }

    public static List<Integer> readWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String numberString = scanner.nextLine();
        List<Integer> winnerNumbers = new ArrayList<>();

        String[] stringNumbers = numberString.split(NUMBER_REGEX);
        for (String stringNumber : stringNumbers) {
            winnerNumbers.add(Integer.parseInt(stringNumber.trim()));
        }
        return winnerNumbers;
    }
}
