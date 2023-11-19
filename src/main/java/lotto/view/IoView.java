package lotto.view;

import lotto.domain.Lotto;

import java.util.*;

import static lotto.util.Util.floorDiv;

public class IoView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        int money = sc.nextInt();
        invalidInputMoney(money);
        System.out.println(floorDiv(money) + "개를 구매했습니다.");
        return money;
    }

    public static String inputWinningNumbers() {
        sc.nextLine();
        System.out.println("지난 주 당첨번호를 입력 해주세요");
        return sc.nextLine();
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    private static void invalidInputMoney(int money) {
        if(money < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액만 가능합니다.");
        }
    }
}
