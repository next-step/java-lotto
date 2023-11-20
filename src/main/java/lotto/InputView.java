package lotto;

import java.util.Scanner;

public class InputView {

    public static void inputPayMoney(){
        System.out.println("구매금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int payMoney = scanner.nextInt();
        int lottoCount = LottoUtil.returnLottoCount(payMoney);

        System.out.println(lottoCount + "개를 구매했습니다.");
    }

}
