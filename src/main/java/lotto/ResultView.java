package lotto;

import java.util.List;

public class ResultView {
    public static void printCount(int count) {
        System.out.println(count + "개를 구입하였습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
