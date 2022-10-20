package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoRunner {
    static public void run() {
        //UI관련 인스턴스 생성
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

        //로또액수 입력
        int totalNumberOfLotto = inputView.enterLottoPrice();

        //수동입력 로또수 입력
        int manualNumberOfLotto = inputView.enterManualCount(totalNumberOfLotto);
        List<List<Integer>> manualLottoNumberInput = inputView.enterManualLottoNumbers(manualNumberOfLotto);

        //로또번호 실행
        int randomNumberOfLotto = LottoVendingMachine.calculateRandomNumberOfLotto(totalNumberOfLotto, manualNumberOfLotto);
        List<LottoNumber> manualLottoNumbers = lottoVendingMachine.makeLottoNumberWithTimes(new ManualGenerator(manualLottoNumberInput), manualNumberOfLotto);
        List<LottoNumber> randomLottoNumbers = lottoVendingMachine.makeLottoNumberWithTimes(new RandomGenerator(), randomNumberOfLotto);
        List<LottoNumber> allLottoNumbers = LottoNumber.merge(manualLottoNumbers, randomLottoNumbers);

        //실행결과 출력
        resultView.printLottoNumbers(allLottoNumbers, manualNumberOfLotto, randomNumberOfLotto);

        //로또 당첨번호 입력
        List<Integer> winNumberInput = inputView.enterWinNumber();
        LottoNumber winNumber = new LottoNumber(winNumberInput);
        BonusLottoNumber bonusNumber = inputView.enterBonusNumber(winNumber);

        //로또실행값 통계 계산
        Analyst analyst = new Analyst(allLottoNumbers, winNumber, bonusNumber);
        CountsByRank countsByRank = analyst.getCountsByRank();
        float revenueRatio = analyst.revenueRatio(countsByRank);

        //로또실행값 통계 출력
        List<Rank> excludeRanks = List.of(Rank.MISS);
        resultView.printCountByRank(countsByRank, excludeRanks);
        resultView.printRevenueRatio(revenueRatio);
    }

    static public void runWhile(Runnable runnable) {
        while (true) {
            runnable.run();
        }
    }

    public static void main(String[] args) {
        runWhile(() -> {
            try {
                LottoRunner.run();
                System.exit(0);
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
