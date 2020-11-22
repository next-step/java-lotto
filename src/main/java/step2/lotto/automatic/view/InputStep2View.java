package step2.lotto.automatic.view;

import java.util.Scanner;

public class InputStep2View {

    private static Scanner sc = new Scanner(System.in);

    private InputStep2View(){

    }

    public static int inputValue() {
        int value = 0;
        System.out.println("구매금액을 입력해주세요");

        try {
            value = Integer.parseInt(sc.nextLine());

            return value;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return value;
    }

    public static String inputWinningLottoNumbers() {
        System.out.println();
        System.out.println("지난주 당첨 결과를 입력해주세요");
        String returnValue = sc.nextLine();

        return returnValue;
    }
}
