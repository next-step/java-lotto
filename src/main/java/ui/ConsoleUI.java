package ui;

import domain.*;
import domain.wrapper.BuyLotto;
import domain.wrapper.EarningRate;
import domain.wrapper.LottoNo;
import domain.wrapper.Money;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleUI {
    public static void main(String[] args) {
        //구입금액입력
        Money price = new Money(InputView.setLottoPayment());
        BuyLotto buyManualLottoCount = new BuyLotto(InputView.setBuyManualLottoCount());
        ResultView.printBuyLottoCount(buyManualLottoCount);

        //수동로또 입력해서 만들기
        List<Lotto> manualLottoNumbers = InputView.setManualLottoNumbers(buyManualLottoCount);
        price.subtract(buyManualLottoCount);
        LottoGroup manualLottoGroup = new LottoGroup(manualLottoNumbers);
        LottoGroup autoLottoGroup = new LottoGroup(price);

        //구매한 로또목록
        ResultView.printLottoGroup(manualLottoGroup, autoLottoGroup);
        LottoGroup lottoGroup = new LottoGroup(manualLottoGroup, autoLottoGroup);
        ResultView.printLottoGroup(lottoGroup);

        //1등로또생성
        LottoNo bonusNum = new LottoNo(Integer.parseInt(InputView.setBonusNumber())) ;
        WinningLotto winningLotto = new WinningLotto(new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber())), bonusNum);
        //당첨된 로또결과 생성
        LottoResultGroup combineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
        ResultView.viewStats();
        ResultView.printStats(combineLottoGroup);
        //수익률 출력
        Money totalRewards = combineLottoGroup.getTotalReward();
        EarningRate totalEarningRate = LottoGame.getTotalEarningRate(price, totalRewards);
        ResultView.printResult(totalEarningRate);
    }
}
