package lotto.view;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private String result;

    public String getResult() {
        return result;
    }


    public void lottoAmountPrint(int lottoAmount) {
        this.result = lottoAmount + "개를 구매했습니다.";
    }

    public void lottoPrint(Lotto lotto) {
        this.result = lotto.getNumbers().toString();
    }

    public void winningPrint(List<Integer> hitNumber, double profit) {
        System.out.println("당첨통계");
        System.out.println("---------");
        for (int i = 3; i < 7; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    i, Prize.calculatePrize(i), Collections.frequency(hitNumber, i));
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profit);
    }
}
