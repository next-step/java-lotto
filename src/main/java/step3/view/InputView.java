package step3.view;

import step3.param.ManualLottoNumberParam;
import step3.param.ManualLottoNumbersParam;
import step3.param.ManualLottoParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    public static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static void newLineRemove() {
        SCANNER.nextLine();
    }

    public static String askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return SCANNER.nextLine();
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int askManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static ManualLottoParam askManualLotto(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        newLineRemove();
        List<ManualLottoNumbersParam> manualLotto = new ArrayList<>();
        for (int i = 0 ; i <manualLottoCount; i++) {
            manualLotto.add(createManualLottoNumbers());
        }
        return ManualLottoParam.from(manualLotto);
    }

    private static ManualLottoNumbersParam createManualLottoNumbers() {
        List<ManualLottoNumberParam> lottoNumbers = new ArrayList<>();
        String numbers = SCANNER.nextLine();
        String[] stringNumbers = numbers.split(DELIMITER);
        for (String number : stringNumbers) {
            lottoNumbers.add(ManualLottoNumberParam.from(Integer.parseInt(number.trim())));
        }

        return ManualLottoNumbersParam.from(lottoNumbers);
    }
}
