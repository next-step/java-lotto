package view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinnerLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] nums = scanner.nextLine().split(",");

        List<Integer> numArrayList = new ArrayList<>();

        for (String num : nums) {
            numArrayList.add(Integer.parseInt(num.trim()));
        }

        return numArrayList;

    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return Integer.parseInt(scanner.next());
    }

}
