package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoCollection;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoNumbers(LottoCollection collection) {
        for (Lotto lotto : collection.getLottos()) {
            System.out.println(getLottoList(lotto));
        }
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printResult(List<Integer> winningNumberCount, double totalProfit) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        System.out.println("3개 일치(5000원)- " + winningNumberCount.get(0) + "개");
        System.out.println("4개 일치(50000원)- " + winningNumberCount.get(1) + "개");
        System.out.println("5개 일치(1500000)- " + winningNumberCount.get(2) + "개");
        System.out.println("6개 일치(2000000000)- " + winningNumberCount.get(3) + "개");

        System.out.println("총 수익률은 " + totalProfit + "입니다.");
    }

    private static List<Integer> getLottoList(Lotto lotto) {
        List<Integer> list = new ArrayList<>();
        for (LottoNumber lottoNumber : lotto.getLotto()) {
            list.add(lottoNumber.getNumber());
        }
        Collections.sort(list);
        return list;
    }
}
