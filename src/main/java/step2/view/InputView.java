package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER = "지난주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int paymentMoney;

    public int paymentMoney() {
        System.out.println(INPUT_MONEY);
        this.paymentMoney = scanner.nextInt();
        return paymentMoney;
    }

    public List<String> manualLottoCount() {
        List<String> manualLottos = new ArrayList<>();
        System.out.println(INPUT_MANUAL_COUNT);
        int lottoCount = scanner.nextInt();
        scanner.nextLine();
        if (lottoCount != 0) {
            manualLottos = manualLottos(lottoCount);
        }
        return manualLottos;
    }

    private List<String> manualLottos(int lottoCount) {
        System.out.println(INPUT_LOTTO_NUMBER);
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            manualLottos.add(scanner.nextLine());
        }
        return manualLottos;
    }

    public String inputWinNumber() {
        System.out.println(INPUT_WIN_NUMBER);
        return scanner.nextLine();
    }

    public int inputBonusInput() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
