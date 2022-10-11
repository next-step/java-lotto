package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public BigDecimal inputPayAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal payAmount = scanner.nextBigDecimal();
        return payAmount;
    }

    public List<Integer> inputBeforeWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        return parseToWinningNumbers(split);
    }

    private List<Integer> parseToWinningNumbers(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : split) {
            winningNumbers.add(Integer.parseInt(s.replace(" ", "")));
        }
        return winningNumbers;
    }
}
