package lotto.view;

import collection.PositiveNumber;

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
    public static long purcharseLotto() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        return new PositiveNumber(sc.next()).getValue();
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

        return toPositiveNums(strPrizeNums);
    }

    public static int getBounsNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);

        return new PositiveNumber(sc.next()).getValue().intValue();
    }

    /**
     * 양의 정수로 변환
     * @param strPrizeNums
     * @return
     */
    private static List<Integer> toPositiveNums(String[] strPrizeNums) {
        ArrayList<Integer> prizeNums = new ArrayList<>();
        for (int i = 0; i < strPrizeNums.length; i++) {
            prizeNums.add(new PositiveNumber(strPrizeNums[i]).getValue().intValue());
        }

        return prizeNums;
    }

    /**
     * 분리
     * @param s
     * @return
     */
    private static String[] split(String s) {
        return s.split(",");
    }
}
