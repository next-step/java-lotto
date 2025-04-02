package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return getNumber();
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getString();
    }

    public static List<String> getManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = getNumber();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> inputs = new ArrayList<>();
        for(int i=0; i<count; i++) {
            inputs.add(getString());
        }
        return inputs;
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static int getBonusNumbers() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getNumber();
    }

}
