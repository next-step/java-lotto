package lotto.view;

import lotto.util.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("LOTTO 구입 금액을 입력해주세요.");
        return inputNumber();
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println("당첨 LOTTO 번호를 입력해주세요.");
        return inputLottoNumbers();
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputNumber();
    }

    private static List<Integer> inputLottoNumbers() {
        String text = SCANNER.nextLine();
        System.out.println();
        return StringSplitter.splitText(text);
    }

    private static int inputNumber() {
        int number;
        try {
            number = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("문자가 입력되었습니다. 숫자만 입력해주세요.");
        }
        System.out.println();
        return number;
    }


}
