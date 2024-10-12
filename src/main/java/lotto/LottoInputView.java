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

        validateLottoNumbers(winningNumbers);

        return winningNumbers;
    }

    public static boolean validateLottoNumbers(List<Integer> numbers) { //todo private
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("번호 갯수가 6개가 아닙니다.");
        }
        return true;
    }
}
