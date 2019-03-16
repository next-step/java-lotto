package lotto.domain;

import java.util.List;

public class LottoMachine {

    /**
     * 당첨번호로 통계 dto 생성
     *
     * @param lottos 구매한 로또들
     * @param winningNumbers 당첨번호들
     * @return 당첨통계 dto
     */
    public static LottoStatistics getLottoStatistics(List<Lotto> lottos, List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            //각 번호별로 체크
            checkWinningNumber(lottos, number);
        }

        //노출 통계자료 생성
        return checkWinningLotto(lottos);
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
    public static LottoStatistics checkWinningLotto(List<Lotto> lottos) {
        LottoStatistics lottoStatistics = new LottoStatistics();

        //등수별 개수
        for (Lotto lotto : lottos) {
            lottoStatistics.incrementPrizeCnt(LottoPrize.getEnumNameByIntValue(lotto.getMatchCount()));
        }

        //수익율
        lottoStatistics.calculateProfit(lottos.size());

        return lottoStatistics;
    }
}
