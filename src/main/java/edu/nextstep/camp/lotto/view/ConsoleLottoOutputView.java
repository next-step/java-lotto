package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.LottoRank;
import edu.nextstep.camp.lotto.domain.Lottos;

import static edu.nextstep.camp.lotto.view.OutputView.print;

public class ConsoleLottoOutputView implements LottoOutputView {

    @Override
    public void buyLottoView(int manualCount, Lottos lottos) {
        print("수동으로 " + manualCount + "장, 자동으로 " + autoLottoCount(manualCount, lottos) + "개를 구매했습니다.");

        print(lottos.toString());
    }

    @Override
    public void lottoAnalysisView(LottoAnalysisResult analysisResult) {
        print("당첨 통계");
        print("---------");

        for (int i = 3; i <= 6; i++) {
            printLotto(analysisResult, i);
        }

        print("총 수익률은 " + analysisResult.earningRate() + "입니다.");
    }

    private int autoLottoCount(int manualCount, Lottos lottos) {
        return lottos.lottoCount() - manualCount;
    }

    private void printLotto(LottoAnalysisResult analysisResult, int matchCount) {
        LottoRank lottoRank = LottoRank.valueOf(matchCount, false);
        print(matchCount + "개 일치 (" + lottoRank.getWinnings() + ")-" + analysisResult.countByLottoRank(lottoRank) + "개");

        if (matchCount == 5) {
            lottoRank = LottoRank.SECOND;
            print(matchCount + "개, 보너스 볼 일치 일치 (" + lottoRank.getWinnings() + ")-" + analysisResult.countByLottoRank(lottoRank) + "개");
        }
    }
}
