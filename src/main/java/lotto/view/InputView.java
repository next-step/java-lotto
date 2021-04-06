package lotto.view;

import lotto.util.PrizeCalculatorUtil;
import lotto.validation.InputViewValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public int inputPrize() throws InputMismatchException {
        System.out.println("구입금액을 입력해 주세요.");

        int count = PrizeCalculatorUtil.getLottoCount(new Scanner(System.in).nextInt());
        InputViewValidator.validatePrizeCount(count);
        return count;
    }

    public String inputWinningLotto() throws InputMismatchException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String number = new Scanner(System.in).nextLine();

        InputViewValidator.validateWinningLotto(number);
        return number;
    }

    public int inputSpecialNumber() throws InputMismatchException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        int number = new Scanner(System.in).nextInt();

        InputViewValidator.validateNumber(number);
        return number;
    }
}
