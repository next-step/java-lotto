package lotto.view;

import lotto.domain.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String SPLIT_DELIMITER = ", ";

    public static int money() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public static List<Integer> winLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = new Scanner(System.in).nextLine();
        return makeNumbers(input);
    }

    public static List<Integer> makeNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] strNumbers = input.split(SPLIT_DELIMITER);
        for (String strNumber : strNumbers) {
            Integer number = validateNumber(strNumber);
            numbers.add(number);
        }
        return numbers;
    }

    public static Integer winLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    private static Integer validateNumber(String strNumber) {
        Integer number = 0;
        try {
            number = Integer.valueOf(strNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로만 구성되어 있지 않은 값이 있습니다.");
        }

        if (number < Numbers.MIN_NUMBER || number > Numbers.MAX_NUMBER) {
            throw new IllegalArgumentException("입력된 숫자 범위가 올바르지 않습니다.");
        }

        return number;
    }

    public static int manualCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요");
        return new Scanner(System.in).nextInt();
    }

    public static List<Numbers> manualNumbers(int manualCount) {
        if(manualCount == 0){
            return null;
        }
        List<Numbers> manualNumbers = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            String input = new Scanner(System.in).nextLine();
            Numbers numbers = new Numbers(makeNumbers(input));
            manualNumbers.add(numbers);
        }
        return manualNumbers;
    }
}
