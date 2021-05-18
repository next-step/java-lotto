package lottoAuto;

import lottoAuto.service.LottoAutoService;
import lottoAuto.service.Lotto;
import lottoAuto.view.LottoAutoResultView;

import java.util.List;

public class LottoAutoApplication {

    public static void main(String[] args) {
        LottoAutoResultView lotto = new LottoAutoResultView();
        LottoAutoService lottoAutoService = new LottoAutoService();

        int amount = lotto.showAmount();
        List<Lotto> userLotto = lotto.showMyLottoInformation(amount);
        Lotto winningLotto = lotto.showWinningNumber();
        int bonusBall = lotto.showBonusBall();

//        List<Integer> winning_count = lottoAutoService.statistic(myLottoNumber, winningNumber);
//        List<Boolean> bonus_count = lottoAutoService.statisticBonus(myLottoNumber, bonusBall);
//
//        List<LottoResultVo> lottoResultVo = lottoAutoService.setWinningStatistic(winning_count, bonus_count);
//        lotto.showWinningStatistic(lottoResultVo);
    }
}