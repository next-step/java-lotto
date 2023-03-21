package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static util.StringConverter.StringToIntegerList;

public class InputView {
    private static final Scanner in = new Scanner(System.in);

    public static int getAmount() {
        System.out.println("구입 금액을 입력하세요.");
        return in.nextInt();
    }

    public static int getManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        return in.nextInt();
    }

    public static List<List<Integer>> getManualLottoNumber(int amount) {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 번호를 입력하세요.");
        in.nextLine(); // Dummy data
        for(int i=0; i < amount; i++) {
            manualLottoNumbers.add(
                    StringToIntegerList(in.nextLine())
            );
        }
        return manualLottoNumbers;
    }

    public static String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력하세요.");
        return in.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력하세요.");
        return in.nextInt();
    }
}
