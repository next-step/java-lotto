package lotto.view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer money() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }

    public static Integer manual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String manualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<Integer> winningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumbers = scanner.nextLine();
        return convertList(splitWinningLottoNumbers(winningLottoNumbers));
    }

    public static Integer bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return convertNumber(scanner.nextLine());
    }

    private static String[] splitWinningLottoNumbers(String input) {
        return input.split(",");
    }

    private static List<Integer> convertList(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            numbers.add(convertNumber(winningNumber));
        }
        return numbers;
    }

    private static Integer convertNumber(String number) {
        return Integer.parseInt(number);
    }

    public static Integer bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("알맞은 금액을 입력해주세요.");
        }
    }
}
