package src.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class InputView {

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber: scanner.nextLine().replace(" ", "").split(",")) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputPurchaseManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void inputPurchaseManualLottoNumber(int manualLottoSize) {
        if (manualLottoSize > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
    }
}
