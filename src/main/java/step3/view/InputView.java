package step3.view;

import step3.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    public static Lotto inputWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = scanner.nextLine().split(",");
        return Lotto.from(convertStrToNum(numbers));
    }

    public static List<Integer> convertStrToNum(String[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.valueOf(number));
        }
        return result;
    }

    public static int inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }
}
