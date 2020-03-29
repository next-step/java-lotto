package lotto.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final String PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_SEPARATOR = ", ";

    private Scanner scanner = new Scanner(System.in);
    private long price;
    private int[] winningNumbers;

    public void inputPrice() {
        price = receivePrice();
    }

    public void inputWinningNumbers() {
        winningNumbers = receiveWinnerNumbers();
    }

    private long receivePrice() {
        System.out.println(PRICE_REQUEST);
        long price = Long.parseLong(scanner.nextLine());
        verifyPrice(price);
        return price;
    }

    private void verifyPrice(long participates) {
        if (participates < 0) {
            throw new IllegalArgumentException(String.format("가격은 음수(%d)를 입력할 수 없습니다.", participates));
        }
    }

    private int[] receiveWinnerNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST);
        String winningNumbersInput = scanner.nextLine();
        verifyWinningNumbersInput(winningNumbersInput);
        String[] split = winningNumbersInput.split(WINNING_NUMBERS_SEPARATOR);
        return Stream.of(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void verifyWinningNumbersInput(String winningNumbersInput) {
        if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    public long getPrice() {
        return price;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }
}
