package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.LottoRank;
import edu.nextstep.camp.lotto.domain.Lottos;

import static edu.nextstep.camp.lotto.domain.LottoGame.LOTTO_BUY_AMOUNT_UNIT;

public class ConsoleLottoOutputView implements LottoOutputView {

    @Override
    public void buyLottoView(int lottoCount, Lottos lottos) {
        print(lottoCount / LOTTO_BUY_AMOUNT_UNIT + "개를 구매했습니다.");
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

    private void printLotto(LottoAnalysisResult analysisResult, int matchCount) {
        LottoRank lottoRank = LottoRank.valueOf(matchCount, false);
        print(matchCount + "개 일치 (" + lottoRank.getWinnings() + ")-" + analysisResult.countByLottoRank(lottoRank) + "개");

        if (matchCount == 5){
            lottoRank = LottoRank.SECOND;
            print(matchCount + "개, 보너스 볼 일치 일치 (" + lottoRank.getWinnings() + ")-" + analysisResult.countByLottoRank(lottoRank) + "개");
        }
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
