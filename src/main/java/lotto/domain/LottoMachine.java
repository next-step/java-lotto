package lotto.domain;

import lotto.dto.Lotto;
import lotto.dto.LottoProfit;
import lotto.dto.LottoStatistics;
import lotto.dto.LottoWinningNumber;

import java.util.List;

public class LottoMachine {

    /**
     * 당첨번호로 통계 dto 생성
     *
     * @param lottos             구매한 로또들
     * @param lottoWinningNumber 당첨번호들
     * @param lottoProfit        수익율 dto
     * @return 당첨통계 dto
     */
    public static LottoStatistics getLottoStatistics(List<Lotto> lottos,
                                                     LottoWinningNumber lottoWinningNumber, LottoProfit lottoProfit) {

        //각 당첨 번호별로 체크
        for (int number : lottoWinningNumber.getWinningNumber()) {
            checkWinningNumber(lottos, number);
        }

        //보너스 번호 체크
        for (Lotto lotto : lottos) {
            lotto.checkBonus(lottoWinningNumber.getBonusNumber());
        }

        //노출 통계자료 생성
        return checkWinningLotto(lottos, lottoProfit);
    }

    /**
     * 당첨번호 하나로 구매한 로또들에 맞은 번호가 있는지 체크
     *
     * @param lottos 구매한 로또들
     * @param number 당첨로또 번호 한개
     */
    public static void checkWinningNumber(List<Lotto> lottos, int number) {
        for (Lotto lotto : lottos) {
            lotto.incrementMatchCount(number);
        }
    }

    /**
     * 구매한 로또들에 저장한 값들로
     * 당첨통계 dto 생성
     *
     * @param lottos 구매한 로또들
     * @return 로또 통계 dto
     */
    public static LottoStatistics checkWinningLotto(List<Lotto> lottos, LottoProfit lottoProfit) {
        LottoStatistics lottoStatistics = new LottoStatistics(lottoProfit);

        //등수별 개수
        for (Lotto lotto : lottos) {
            lottoStatistics.incrementPrizeCnt(LottoPrize.getEnumNameByIntValue(lotto.getMatchCount(), lotto.isMatchBonus()));
        }

        //수익율
        lottoProfit.calculateProfit(lottoStatistics.getFifthCnt(), lottoStatistics.getForthCnt(), lottoStatistics.getThirdCnt(),
                lottoStatistics.getSecondCnt(), lottoStatistics.getFirstCnt());

        return lottoStatistics;
    }
}
