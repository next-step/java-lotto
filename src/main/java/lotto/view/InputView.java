package lotto.view;

import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MSG_MONEY = "구입 금액을 입력해주세요.";
    private static final String MSG_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MSG_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String REGEX = ",";

    public Money inputMoney() {
        System.out.println(MSG_MONEY);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return new Money(input);
    }

    public List<Integer> inputWinNumbers() {
        System.out.println(MSG_WIN_NUMBERS);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replace(" ", "");
        String[] inputStrings = input.split(REGEX);

        List<Integer> lottoNumbers = new ArrayList<>();
        for (String i : inputStrings) {
            lottoNumbers.add(Integer.parseInt(i));
        }
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(MSG_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
