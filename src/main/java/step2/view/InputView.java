package step2.view;

import step2.domain.Prize;
import step2.validation.InputViewValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public int inputPrize() throws InputMismatchException {
        Prize prize = new Prize();
        System.out.println("구입금액을 입력해 주세요.");

        int count = prize.getLottoCount(new Scanner(System.in).nextInt());
        InputViewValidator.prizeCountValidate(count);
        return count;
    }

    public String inputWinningLotto() throws InputMismatchException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String number = new Scanner(System.in).nextLine();

        InputViewValidator.winningLottoValidate(number);
        return number;
    }
}
