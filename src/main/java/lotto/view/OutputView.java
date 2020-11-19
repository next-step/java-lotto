package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PrizeWinningResult;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;

public class OutputView {

    private PrintWriter writer = new PrintWriter(System.out);

    public void showPurchasedLottos(List<Lotto> myLottos) {
        writer.println(myLottos.size() + "개를 구매했습니다");
        myLottos.forEach(it -> {
            writer.print("[");
            it.printNumber(writer);
            writer.print("]\n");
        });
        writer.flush();
    }

    public void showResult(PrizeWinningResult result) {
        writer.println("");
        writer.println("당첨 통계");
        writer.println("-----------");
        writer.println(MessageFormat.format("3개 일치 ({0}) - {1}개", result.getFifthPrizeMoney(), result.getFifthPrizeCount()));
        writer.println(MessageFormat.format("4개 일치 ({0}) - {1}개", result.getFourthPrizeMoney(), result.getFourthPrizeCount()));
        writer.println(MessageFormat.format("5개 일치 ({0}) - {1}개", result.getThirdPrizeMoney(), result.getThirdPrizeCount()));
        writer.println(MessageFormat.format("5개 일치, 보너스 볼 일치 ({0}) - {1}개", result.getSecondPrizeMoney(), result.getSecondPrizeCount()));
        writer.println(MessageFormat.format("6개 일치 ({0}) - {1}개", result.getFirstPrizeMoney(), result.getFirstPrizeCount()));
        writer.print(MessageFormat.format("총 수익률은 {0,number,#.##} 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", result.getRateOfReturn()));
        writer.flush();
    }
}
