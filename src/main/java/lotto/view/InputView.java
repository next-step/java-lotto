package lotto.view;

import collection.IntegerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 로또 구매
     * @return
     */
    public static int purcharseLotto() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        return new IntegerWrapper(sc.next()).getValue();
    }

    /**
     * 당첨번호 가져오기
     * @return
     */
    public static List<Integer> getPrizeNums() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strPrizeNums = split(s);

        ArrayList<Integer> prizeNums = new ArrayList<>();
        for (int i = 0; i < strPrizeNums.length; i++) {
            int prizeNum = Integer.parseInt(strPrizeNums[i]);
            prizeNums.add(prizeNum);
        }

        return prizeNums;
    }

    private static String[] split(String s) {
        return s.split(",");
    }
}
