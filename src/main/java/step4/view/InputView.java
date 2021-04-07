package step4.view;

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

    public final int inputMoneyByClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    public final int inputPassiveCountByClient() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    public static final void printInputPassiveLotto() {
        System.out.println("수동으로 구매할 로또를 입력해 주세요.");
    }

    public final String inputPassiveLottoByClient() {
        return scanner.nextLine();
    }

    public final String inputLottoNumbersByClient() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public final int inputBonusLottoNumbersByClient() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }


}
