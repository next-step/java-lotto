package step2.view;

import step2.Lotto;
import step2.LottoNumber;
import step2.LottoStore;
import step2.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static void printLottoList(LottoStore lottoStore) {
        System.out.println("수동으로 " + lottoStore.getManualLottoCount() + "장, 자동으로 " + lottoStore.getAutoLottoCount() + "개를 구매했습니다.");
        Lottos lottos = lottoStore.getLottos();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumberString());
        }
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> inputManualNumbers() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = parsePositiveInt(scanner.nextLine());

        List<String> manualInputs = new ArrayList<>();
        if (manualCount > 0) {
            System.out.println("수동으로 구매할 번호를 입력해주세요.");
        }
        for (int i = 0; i < manualCount; i++) {
            manualInputs.add(scanner.nextLine());
        }
        return manualInputs;
    }

    private static int parsePositiveInt(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("양의 정수를 입력해주세요.");
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return parsePositiveInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return parsePositiveInt(scanner.nextLine());
        }
    }
}
