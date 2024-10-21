package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPaidAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨번호를 입력해주세요");
        scanner.nextLine();

        String numberStr = scanner.nextLine();
        List<Integer> winningNumbers = Arrays.stream(numberStr.replaceAll(" ", "").split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        int bonusNumber = scanner.nextInt();

        if (bonusNumber <= 0 || bonusNumber > 45) { //todo
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return bonusNumber;
    }

}
