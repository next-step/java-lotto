package lotto.step2.view;

import lotto.step2.domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class ResultView {

    private static final Scanner sc = new Scanner(System.in);

    public static void printOrderCount(int totalCount) {
        System.out.println(totalCount + "개를 구매했습니다.");
    }

    public static void printOrderLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumber().getNumber());
        }
    }

}
