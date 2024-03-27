package common.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumbers;

public class LottoInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        System.out.println("구매할 금액을 입력하세요.");
        int amount = validateInt(scanner.nextInt());
        scanner.nextLine();
        return amount;
    }

    public static LottoNumbers requestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.nextLine().split(",");
        return new LottoNumbers(Arrays.stream(input)
            .map(String::trim)
            .map(s -> s.replaceAll("\\s+",""))
            .map(Integer::parseInt)
            .collect(Collectors.toList()));
    }

    public static int validateInt (int input) {
        if (input<0) {
            throw new IllegalArgumentException("음수일 수 없습니다.");
        }
        return input;
    }
}
