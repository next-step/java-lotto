package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_AMOUNT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private void isDigit(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isOverMinAmount(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    private void isValidNumberCount(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        if (numbers.length < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해주셔야합니다.");
        }
    }

    public String ask(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    public int getLottoCount(String amount) {
        isBlank(amount);

        isDigit(amount);

        isOverMinAmount(amount);

        int purchaseAmount = getPurchaseAmount(amount);
        int lottoCount = purchaseAmount/LOTTO_PRICE;

        return lottoCount;
    }

    public int getPurchaseAmount(String amount) {
        return Integer.parseInt(amount);
    }

    public List<Integer> getWinningNumbers(String winningNumbers) {
        isBlank(winningNumbers);

        isValidNumberCount(winningNumbers);

        String[] numbers = winningNumbers.split(",");
        for (String number : numbers) {
            isDigit(number);
        }

        List<Integer> winningNumberList = new ArrayList<>();
        for (String number : numbers) {
            isDuplicate(winningNumberList, Integer.parseInt(number));
        }

        return winningNumberList;
    }

    private void isDuplicate(List<Integer> winningNumberList, int winningNumber) {
        if (winningNumberList.contains(winningNumber)) {
            throw new IllegalArgumentException("당첨번호가 중복되었습니다. 다시 입력해주세요");
        }

        winningNumberList.add(winningNumber);
    }
}
