package step2.view;

import step2.model.Lotto;
import step2.model.LottoWinnings;
import step2.model.Lottos;

public class LottoOutput {

    public void printLottoResult(Lottos lottos, Lotto winner) {
        LottoResultDto lottoResultDto = new LottoResultDto(lottos, winner);
        System.out.println("당첨 통계");
        System.out.println("-----------------");
        System.out.println("3개 일치 (" + LottoWinnings.THREE.getWinnings() + "원) - " + lottoResultDto.getThreeMatchCount());
        System.out.println("4개 일치 (" + LottoWinnings.FOUR.getWinnings() + "원) - " + lottoResultDto.getFourMatchCount());
        System.out.println("5개 일치 (" + LottoWinnings.FIVE.getWinnings() + "원) - " + lottoResultDto.getFiveMatchCount());
        System.out.println("6개 일치 (" + LottoWinnings.SIX.getWinnings() + "원) - " + lottoResultDto.getSixMatchCount());
        System.out.println("총 수익률은 " + lottoResultDto.getYield() + "입니다.");
    }
}
