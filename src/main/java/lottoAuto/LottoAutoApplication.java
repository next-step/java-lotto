package lottoAuto;

import lottoAuto.service.LottoAutoService;
import lottoAuto.view.LottoAutoResultView;

import java.util.List;

public class LottoAutoApplication {

    public static void main(String[] args) {
        LottoAutoResultView lotto = new LottoAutoResultView();
        LottoAutoService lottoAutoService = new LottoAutoService();

        List<List> myLottoNumber = lotto.showMyLottoInformation();
        List<Integer> winningNumber = lotto.showWinningNumber();
        int bonusBall = lotto.showBonusBall();

        List<Integer> winning_count = lottoAutoService.statistic(myLottoNumber,winningNumber);
        List<Integer> bonus_count = lottoAutoService.statisticBonus(myLottoNumber,bonusBall);

        lotto.showWinningStatistic(winning_count,bonus_count);
    }
}