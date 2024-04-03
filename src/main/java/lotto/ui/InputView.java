package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmount() {
        System.out.println("구매금액을 입력하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<List<Integer>> inputManualNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> numbers = convertListNumber(scanner.nextLine());
            manualNumbers.add(numbers);
        }

        return manualNumbers;
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberText = scanner.nextLine();

        return convertListNumber(numberText);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
    
    private List<Integer> convertListNumber(String numberText) {
        String[] splitNumber = numberText.split(",");
        return Arrays.stream(splitNumber)
            .map(number -> Integer.parseInt(number.trim()))
            .collect(Collectors.toList());
    }
}
