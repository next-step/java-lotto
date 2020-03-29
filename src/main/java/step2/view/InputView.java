package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static int askTotalPrice() {
        System.out.println("구입금액을 입력해 주세요");
        scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static List<Integer> askWinnerLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner = new Scanner(System.in);
        List<Integer> winnerLottoNumber = new ArrayList<>();

        String[] splitString = split(scanner.nextLine());

        for (int i = 0; i < splitString.length; i++) {
            winnerLottoNumber.add(Integer.parseInt(splitString[i]));
        }



        return winnerLottoNumber;
    }

    private static String[] split(String nextLine) {
        return nextLine.split(",");
    }
}
