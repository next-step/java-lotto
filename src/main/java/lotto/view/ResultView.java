package lotto.view;

import lotto.domain.Lotto;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoCount(int lottoPrice) {
        System.out.println(lottoPrice+"개를 구매했습니다.");
    }

    public static void printLottoNumber(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printWinningCount(Map<Integer, Integer> winningCount, int lottoPrice) {
        System.out.println("\n당첨 통계\n--------");
        int[] winningMoney = {5000, 50000, 1500000, 2000000000};

        float sum = 0;
        for(int i=3; i<7; i++) {
            System.out.println(i+"개 일치 ("+winningMoney[i-3]+"원)- "+winningCount.get(i)+"개");
            sum += winningMoney[i-3] * winningCount.get(i);
        }

        System.out.println("총 수익률은 "+ (sum/lottoPrice) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
