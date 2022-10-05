package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String BUY_TEXT = "구입금액을 입력해 주세요.";
    public static final Scanner sc = new Scanner(System.in);

    public static int buyLotto() {
        System.out.println(BUY_TEXT);
        return sc.nextInt();
    }

    public static void printLottoCount(int lottoNum) {
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public static void printLottoNum(ArrayList<List<Integer>> lottoArray) {
        for (List<Integer> lotto : lottoArray) {
            System.out.println(lotto.toString());
        }
    }
}
