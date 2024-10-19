package lotto.view;

import java.util.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int getMoney() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        int money = SCANNER.nextInt();
        SCANNER.nextLine();
        return money;
    }

    public static Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호 [6자리]를 입력해 주세요.");

        String input = SCANNER.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("입력 값이 비어 있습니다. 다시 입력해 주세요.");
            return getWinningNumbers();
        }

        String[] inputList = input.split(",");
        Set<Integer> winningNumbers = new HashSet<>();

        try {
            for (String stringNumber : inputList) {
                int number = Integer.parseInt(stringNumber.trim());

                if (number < 1 || number > 45) {
                    System.out.println("로또 번호는 1부터 45 범위 안에 있습니다.");
                    return getWinningNumbers();
                }

                if (!winningNumbers.add(number)) {
                    System.out.println("중복된 숫자가 있습니다. 다시 입력해 주세요.");
                    return getWinningNumbers();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return getWinningNumbers();
        }

        if (winningNumbers.size() != 6) {
            System.out.println("여섯 자리를 입력해 주세요.");
            return getWinningNumbers();
        }

        return winningNumbers;
    }
}
