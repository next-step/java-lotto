package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.WinningNumber;

public class InputView {

    public BigDecimal inputPayAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal payAmount = scanner.nextBigDecimal();
        return payAmount;
    }

    public WinningNumber inputWinningNumberWithBonus() {
        List<Integer> winningNumber = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        return new WinningNumber(winningNumber, bonusNumber);
    }

    private int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = scanner.nextInt();
        return bonusNum;
    }

    private List<Integer> inputWinningNumber() {
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
