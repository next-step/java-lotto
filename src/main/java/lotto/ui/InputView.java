package lotto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualSelectLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = Integer.parseInt(scanner.nextLine());
        if (count < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return count;
    }

    public static String getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int getBonusNo() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> getManualLottoNumbers(int manualSelectCount) {
        if (manualSelectCount == 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < manualSelectCount; i++) {
            numbers.add(scanner.nextLine());
        }
        return numbers;
    }
}
