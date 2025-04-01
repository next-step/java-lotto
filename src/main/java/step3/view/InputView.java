package step3.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputNum();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputNum();
    }

    public static List<String> inputManualLottosNums(int lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoNumsInputs = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            String lottoNums = SCANNER.nextLine();
            lottoNumsInputs.add(lottoNums);
        }
        return lottoNumsInputs;
    }


    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputNum();
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputNum() {
        try {
            int num = SCANNER.nextInt();
            SCANNER.nextLine();
            return num;
        } catch (InputMismatchException e) {
            throw new RuntimeException("금액은 정수 숫자만 가능합니다.");
        }
    }
}
