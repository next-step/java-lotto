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

    public void showResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Winning winning : result.winnings()) {
            showWinning(winning);
        }
        System.out.println();
        showRateOfReturn(result.rateOfReturn());
    }

    private void showRateOfReturn(double rateOfReturn) {
        String message = "총 수익률은 " + rateOfReturn + "입니다.";
        if (rateOfReturn < 1) {
            System.out.println(message + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        if (rateOfReturn > 1) {
            System.out.println(message + "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
            return;
        }
        System.out.println(message + "(기준이 1이기 때문에 결과적으로 손해나 이익이 아니라는 의미임)");
    }
    
    private void showNumbers(LottoNumbers numbers) {
        for (LottoNumber lottoNumber : numbers) {
            System.out.println(lottoNumber.numbers());
        }
        System.out.println();
    }
    
    private void showWinning(Winning winning) {
        String message = winning.matchCount() + "개 일치(" + winning.prize() + "원)- " + winning.numberCount() + '개';
        if (winning.hasBonusNumber()) {
            message = winning.matchCount() + "개 일치, 보너스 볼 일치(" + winning.prize() + "원)- " + winning.numberCount() + '개';
        }
        System.out.println(message);
    }
}
