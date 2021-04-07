package step4.view;

import step4.domain.money.Money;
import step4.domain.winning.WinningLotto;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;

    private static class InputViewHolder {
        public static final InputView instance = new InputView();
    }

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static final InputView getInstance() {
        return InputViewHolder.instance;
    }

    private final int inputMoneyByClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    private final String inputLottoNumbersByClient() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private final int inputBonusLottoNumbersByClient() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }


}
