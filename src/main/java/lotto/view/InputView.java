package lotto.view;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_COUNT = 6;

    private InputView() {
    }

    public static int getMoney() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        int money = SCANNER.nextInt();
        SCANNER.nextLine();
        return money;
    }

    public static Set<Integer> getWinningNumbers() {
        System.out.println(String.format("지난 주 당첨 번호 [%d자리]를 입력해 주세요.", LOTTO_COUNT));

        while (true) {
            String input = SCANNER.nextLine().trim();
            Set<Integer> winningNumbers = parseInputToNumbers(input);
            if (winningNumbers != null && winningNumbers.size() == LOTTO_COUNT) {
                return winningNumbers;
            }
            System.out.println(String.format("%d개의 중복되지 않는 유효한 번호를 입력해 주세요.", LOTTO_COUNT));
        }
    }

    private static Set<Integer> parseInputToNumbers(String input) {
        if (input.isEmpty()) {
            System.out.println("입력 값이 비어 있습니다. 다시 입력해 주세요.");
            return null;
        }

        Set<Integer> winningNumbers = new HashSet<>();
        String[] inputList = input.split(",");

        for (String stringNumber : inputList) {
            Integer number = parseNumber(stringNumber.trim());
            if (number == null) {
                return null;
            }
            winningNumbers.add(number);
        }
        return winningNumbers;
    }
    
    private static Integer parseNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);

            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                System.out.println(String.format("로또 번호는 %d부터 %d 범위 안에 있어야 합니다.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
                return null;
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return null;
        }
    }

    public static int getBonusBall() {
        System.out.println(String.format("보너스 볼을 입력해 주세요."));
        int bonusBall = SCANNER.nextInt();
        SCANNER.nextLine();
        return bonusBall;
    }
}
