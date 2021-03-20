package lotto.views;

import lotto.domain.Lotto;
import lotto.domain.LottoResultDto;
import lotto.domain.WinningTable;

import java.io.PrintStream;
import java.util.List;

public class ResultView {
    private final PrintStream out;

    public ResultView() {
        out = System.out;
    }

    public void showWinningResult(LottoResultDto lottoResultDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoResultDto.resultMap().forEach((matchNumber, matchCount) -> {
            System.out.println(matchNumber + "개 일치 (" + WinningTable.of(matchNumber).winningAmount + ")- " + matchCount + "개");
        });
        System.out.printf("총 수익률은 %.2f 입니다.", lottoResultDto.yeild());
    }

    public void showPurchaseQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
        System.out.println();
    }

    public void showPurchaseLotto(List<Lotto> lottos) {
        showPurchaseQuantity(lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }
}
