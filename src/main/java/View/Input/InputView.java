package View.Input;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public int getInputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public ArrayList<Integer> inputWinnerLottoNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] nums = scanner.next().split(",");

        ArrayList<Integer> numArrayList = new ArrayList<>();

        for (String num : nums) {
            numArrayList.add(Integer.parseInt(num));
        }

        return numArrayList;

    }

}
