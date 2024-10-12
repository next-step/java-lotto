package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private int purchasingAmount = 0;
    private final Scanner scanner = new Scanner(System.in);

    public int receivePurchasingAmount() {
        this.purchasingAmount = scanner.nextInt();
        scanner.nextLine();
        validatePurchasingAmount();
        printBuyLotto();
        return purchasingAmount / 1000;
    }

    public List<Integer> receiveWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        validateWinningNumber(input);
        return convertWinningNumber(input);
    }

    public int getPurchasingAmount() {
        return this.purchasingAmount;
    }

    private void validatePurchasingAmount() {
        if (purchasingAmount / 1000 < 1) {
            throw new IllegalArgumentException("그 돈으로는 로또를 한 장도 살 수 없습니다. 돌아가세요!");
        }
    }

    private void printBuyLotto() {
        System.out.println(purchasingAmount / 1000 + "개를 구매했습니다.");
        printReturnChange();
    }

    private void printReturnChange() {
        if (purchasingAmount % 1000 > 0) {
            System.out.println("거스름돈 " + purchasingAmount % 1000 + "원을 받았습니다.");
        }
    }

    private List<Integer> convertWinningNumber(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumber(String input) {
        List<String> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }


        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("각 당첨 번호는 1과 45 사이여야 합니다.");
            }
        }
    }
}
