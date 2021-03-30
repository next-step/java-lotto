package step2.view;

import step2.domain.Prize;
import step2.validation.InputViewValidator;

import java.util.Scanner;

public class InputView {
    Scanner scan;

    public InputView() {
        this.scan = new Scanner(System.in);
    }

    public int inputPrize() {
        Prize prize = new Prize();
        System.out.println("구입금액을 입력해 주세요.");

        int count = prize.getLottoCount(scan.nextInt());
        InputViewValidator.prizeCountValidate(count);
        return count;
    }
}
