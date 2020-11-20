package step2.lotto.automatic.view;

import java.util.Scanner;

public class InputStep2View {

    private static Scanner sc = new Scanner(System.in);

    public int inputValue() {
        int value = 0;
        System.out.println("구매금액을 입력해주세요");

        try {
            value = sc.nextInt();
            sc.nextLine();
            return value;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return value;
    }

    public String inputWinningLottoNumbers() {
        String returnValue = sc.nextLine();
        return returnValue;
    }
}
