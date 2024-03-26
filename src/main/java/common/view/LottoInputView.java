package common.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static int requestPurchaseAmount() {
        System.out.println("구매할 금액을 입려하세요.");
        return validateInt(scanner.nextInt());
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.next().split(",");
        inputLenCheck(input, LOTTO_NUMBER_COUNT);
        return Arrays.stream(input)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoInputView::validateInt)
            .collect(Collectors.toList());
    }

    public static int validateInt (int input) {
        if (input<0) {
            throw new IllegalArgumentException("음수일 수 없습니다.");
        }
        return input;
    }

    public static void inputLenCheck(String[] input, int checkLen) {
        if(input.length != checkLen) {
            throw new IllegalArgumentException(String.format("%s개 만큼 입력해야합니다.", checkLen));
        }
    }
}
