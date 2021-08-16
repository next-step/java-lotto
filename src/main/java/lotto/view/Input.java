package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getManualGameCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> getManualNumbers(int manualGameCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> numberList = new ArrayList<>();
        scanner.nextLine();
        for (int count = 0; count < manualGameCount; count++) {
            numberList.add(scanner.nextLine());
        }
        return numberList;
    }

    public static String getPastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    public static int getBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
