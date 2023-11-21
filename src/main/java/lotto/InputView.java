package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputPayMoney(){
        System.out.println("구매금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int payMoney = scanner.nextInt();

        return payMoney;
    }

    public static List<Integer> inputWinningNumbers(){
        List<Integer> winningNumber = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);

        return LottoUtil.settingWinnerNumber(winningNumber, LottoUtil.splitString(scanner.nextLine()));
    }

}
