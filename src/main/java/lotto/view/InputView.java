package lotto.view;

import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int askMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return toInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return askMoney();
    }

    public List<LottoNumber> askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            return convertTo(SCANNER.nextLine());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return askWinningNumbers();
    }

    private List<LottoNumber> convertTo(String input) {
        String[] winningNumbers = input.split(", ");

        List<LottoNumber> result = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            result.add(new LottoNumber(toInt(winningNumber)));
        }

        return result;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

}
