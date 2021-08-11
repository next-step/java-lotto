package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step2.model.LottoValidator.*;

public class InputView {
    private static final int LOTTO_NUMBER_COUNT = 6;

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
