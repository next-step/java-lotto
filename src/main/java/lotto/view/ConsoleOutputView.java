package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Number;
import lotto.domain.Result;
import lotto.domain.Winning;

public class ConsoleOutputView {
    public void showPurchase(LottoNumbers numbers) {
        System.out.println(numbers.count() + "개를 구매했습니다.");
        showNumbers(numbers);
    }

    private void showNumbers(LottoNumbers numbers) {
        for (Number number : numbers) {
            showNumber(number);
        }
        System.out.println();
    }

    public void showNumber(Number number) {
        System.out.println(number.numbers());
    }

    public void showResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Winning winning : result) {
            System.out.println(winning.matchCount()+"개 일치("+winning.prize()+"원)- "+winning.numberCount());
        }
        System.out.println();
    }
}
