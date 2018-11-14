package ui;

import domain.*;
import domain.wrapper.BuyLotto;
import domain.wrapper.EarningRate;
import domain.wrapper.LottoNo;
import domain.wrapper.Money;
import utils.LottoNumberGenerator;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleUI {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        //구입금액입력
        Money price = new Money(InputView.setLottoPayment());
        BuyLotto buyManualLottoCount = new BuyLotto(InputView.setBuyManualLottoCount());
        ResultView.printBuyLottoCount(buyManualLottoCount);

        //수동로또 입력해서 만들기
        List<Lotto> manualLottoNumbers = InputView.setManualLottoNumbers(buyManualLottoCount);
        price.subtract(buyManualLottoCount);
        LottoGroup manualLottoGroup = new LottoGroup(manualLottoNumbers);
        LottoGroup autoLottoGroup = new LottoGroup(lottoNumberGenerator.generate(price));

        //구매한 로또목록
        ResultView.printLottoGroups(manualLottoGroup, autoLottoGroup);
        LottoGroup lottoGroup = new LottoGroup(manualLottoGroup, autoLottoGroup);
        ResultView.printTotalLottoGroup(lottoGroup);

        //1등로또생성
        Lotto lastLotto = new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber()));
        LottoNo bonusNum = new LottoNo(Integer.parseInt(InputView.setBonusNumber())) ;
        WinningLotto winningLotto = new WinningLotto(lastLotto, bonusNum);
        //당첨된 로또결과 생성
        LottoResultGroup combineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
        ResultView.viewStats();
        ResultView.printStats(combineLottoGroup);
        //수익률 출력
        Money totalRewards = combineLottoGroup.getTotalReward();
        EarningRate totalEarningRate = new EarningRate(price,totalRewards);
        ResultView.printResult(totalEarningRate);
    }
}
