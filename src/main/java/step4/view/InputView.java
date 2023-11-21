package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PUT_PAY_PRICE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PUT_LAST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public int payPriceInput() {
        System.out.println(PUT_PAY_PRICE);
        return scanner.nextInt();
    }

    public int manualLottoCountInput() {
        scanner.nextLine();
        System.out.println(MANUAL_LOTTO_COUNT);
        return scanner.nextInt();
    }

    public List<String> manualLottoNumberInput(int manualLottoCount) {
        scanner.nextLine();
        List<String> manualLottoNumber = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBERS);

        for (int i=0; i<manualLottoCount; i++) {
            manualLottoNumber.add(scanner.nextLine());
        }
        return manualLottoNumber;
    }

    public String putLastWinNumbers() {
        System.out.println(PUT_LAST_WIN_NUMBERS);
        return scanner.nextLine();
    }

    public int bonusNumberInput() {
        System.out.println(PUT_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
