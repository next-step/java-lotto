package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static int inputPay(Scanner scanner) {
        System.out.println("구입 금액을 입력하세요.");
        return scanner.nextInt();
    }

    public static Set<Integer> lastWinNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Set<Integer> numbers = new HashSet<>();
        inputLastNumbers(numbers, scanner);
        return numbers;
    }

    public static int inputBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static void inputLastNumbers(Set<Integer> numbers, Scanner scanner) {
        int count = 0;
        while (count < 6 && scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
            count++;
        }
        if (count == 6 && scanner.hasNext()) {
            System.out.println("입력값이 6개를 초과하여 추가 입력은 무시됩니다.");
        }
    }

    public static int inputCount(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Set<Integer>> inputManualNumbers(int manualCount, Scanner scanner) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> numberList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Set<Integer> lottoNumbers = inputLottoNumbers(scanner);
            numberList.add(lottoNumbers);
        }

        return numberList;
    }

    private static Set<Integer> inputLottoNumbers(Scanner scanner) {
        Set<Integer> lottoNumbers = new HashSet<>();
        int count = 0;
        while (count < 6 && scanner.hasNextInt()) {
            int number = scanner.nextInt();
            lottoNumbers.add(number);
            count++;
        }
        if (count == 6 && scanner.hasNext()) {
            System.out.println("입력값이 6개를 초과하여 추가 입력은 무시됩니다.");
        }
        return lottoNumbers;
    }
}
