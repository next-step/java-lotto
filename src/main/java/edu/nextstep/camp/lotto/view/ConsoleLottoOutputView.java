package edu.nextstep.camp.lotto.view;

import edu.nextstep.camp.lotto.domain.LottoAnalysisResult;
import edu.nextstep.camp.lotto.domain.LottoRank;
import edu.nextstep.camp.lotto.domain.Lottos;

public class ConsoleLottoOutputView implements LottoOutputView{

    @Override
    public void buyLottoView(int lottoCount, Lottos lottos) {
        print(lottoCount/1000+"개를 구매했습니다.");
        print(lottos.toString());
    }

    @Override
    public void lottoAnalysisView(LottoAnalysisResult analysisResult) {
        print("당첨 통계");
        print("---------");

        for (int i = 3; i <= 6; i++) {
            LottoRank lottoRank = LottoRank.withMatchNumberCount(i);
            print(i+"개 일치 (" + lottoRank.getWinnings() + ")-"+analysisResult.countByLottoRank(lottoRank)+"개");
        }

        print("총 수익률은 "+analysisResult.earningRate()+"입니다.");
    }

    private void print(String msg){
        System.out.println(msg);
    }
}
