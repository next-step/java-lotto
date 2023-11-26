package lottoView;

import lottoController.LottoDomain;
import lottoModel.LottoInputValue;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String text = SCANNER.nextLine();
        return LottoInputValue.convertNum(text);
    }

    public static LottoInputValue lastLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoInputValue(SCANNER.nextLine());
    }

    public static LottoInputValue manualLottoNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int enterCount = 0;
        String text = "";

        while (enterCount < manualCount) {

            if ("".equals(text)) {
                text = text.concat(scanner.nextLine());
                enterCount++;
                continue;
            }
            text = text.concat("\n" + scanner.nextLine());
            enterCount++;
        }
        return new LottoInputValue(text);
    }

    public static LottoInputValue inputLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoInputValue(SCANNER.nextLine());
    }

    public static int inputLottoManualNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String text = SCANNER.nextLine();
        return LottoInputValue.convertNum(text);
    }
}
