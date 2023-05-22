package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> manualLottoNumberView(int manualLottoAccount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoStrings = new ArrayList<>();
        for (int i = 0; i < manualLottoAccount; i++) {
            lottoStrings.add(scanner.nextLine());
        }
        return lottoStrings;
    }

    public int manualLottoView() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String number = scanner.nextLine();
        return Integer.parseInt(number);
    }

    public int priceView() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        return Integer.parseInt(price);
    }

    public String winnerNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String bonusNumbersView() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}
