package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력하세요.");
        return scanner.nextInt();
    }

    public static Set<Integer> lastWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<Integer> numbers = inputLastNumbers();
        return numbers;
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static Set<Integer> inputLastNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] lottoNumbers = scanner.nextLine().split("[\\s,]+");
        if (lottoNumbers.length > 6) {
            throw new IllegalStateException("로또 번호는 6개까지 입력 됩니다.");
        }
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static int inputCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Set<Integer>> inputManualNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> numberList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Set<Integer> lottoNumbers = inputLottoNumbers();
            numberList.add(lottoNumbers);
        }

        return numberList;
    }

    private static Set<Integer> inputLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] lottoNumbers = scanner.nextLine().split("[\\s,]+");
        if (lottoNumbers.length > 6) {
            throw new IllegalStateException("로또 번호는 6개까지 입력 됩니다.");
        }
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
