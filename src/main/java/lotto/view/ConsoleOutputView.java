package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Result;
import lotto.domain.Winning;

public class ConsoleOutputView {
    public void showPurchase(LottoNumbers numbers) {
        System.out.println(numbers.count() + "개를 구매했습니다.");
        showNumbers(numbers);
    }

    private void showNumbers(LottoNumbers numbers) {
        for (LottoNumber lottoNumber : numbers) {
            showNumber(lottoNumber);
        }
        System.out.println();
    }

    public void showNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.numbers());
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
