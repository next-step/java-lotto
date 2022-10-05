package step2;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printLottoCount(int lottoNum) {
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public static void printLottoNum(ArrayList<List<Integer>> lottoArray) {
        for (List<Integer> lotto : lottoArray) {
            System.out.println(lotto.toString());
        }
    }
}
