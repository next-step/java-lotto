package step2.view;

import java.util.List;
import step2.model.Lotto;
import step2.model.LottoNumbers;
import step2.model.LottoWinnings;
import step2.model.Lottos;

public class LottoOutput {

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        System.out.println(lottoList.size() + "개를 구매했습니다");
        lottoList.forEach(LottoOutput::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        LottoNumbers lottoNumbers = lotto.getLottoNumbers();
        System.out.println(lottoNumbers);
    }

    public static void printLottoResult(LottoResultDto result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-----------------");
        System.out.println("3개 일치 (" + LottoWinnings.THREE.getWinnings() + "원) - " + result.getThreeMatchCount());
        System.out.println("4개 일치 (" + LottoWinnings.FOUR.getWinnings() + "원) - " + result.getFourMatchCount());
        System.out.println("5개 일치 (" + LottoWinnings.FIVE.getWinnings() + "원) - " + result.getFiveMatchCount());
        System.out.println("6개 일치 (" + LottoWinnings.SIX.getWinnings() + "원) - " + result.getSixMatchCount());
        System.out.printf("총 수익률은 %.2f입니다.", result.getYield());
    }
}
