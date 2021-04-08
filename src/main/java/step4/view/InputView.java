package step4.view;

import java.util.Scanner;

public final class InputView {

    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_PASSIVE_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_PASSIVE_LOTTOS_MESSAGE = "수동으로 구매할 로또를 입력해 주세요.";
    public static final String INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_LOTTONUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

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
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.valueOf(scanner.nextLine());
    }

    public final int inputPassiveCountByClient() {
        System.out.println(INPUT_PASSIVE_LOTTO_COUNT_MESSAGE);
        return Integer.valueOf(scanner.nextLine());
    }

    public static final void printInputPassiveLotto() {
        System.out.println(INPUT_PASSIVE_LOTTOS_MESSAGE);
    }

    public final String inputPassiveLottoByClient() {
        return scanner.nextLine();
    }

    public final String inputLottoNumbersByClient() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public final int inputBonusLottoNumbersByClient() {
        System.out.println(INPUT_BONUS_LOTTONUMBER_MESSAGE);
        return Integer.valueOf(scanner.nextLine());
    }


}
