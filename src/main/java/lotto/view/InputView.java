package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String priceOfPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String numOfManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> numberOfManual(int num) {
        List<String> result = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i =0;i<num;i++){
            String line = scanner.nextLine();
            result.add(line);
        }

        return result;
    }

    public static String numberOfWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (숫자는 ','로 구분)\n");
        return scanner.nextLine();
    }

    public static String numberOfBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }


}
